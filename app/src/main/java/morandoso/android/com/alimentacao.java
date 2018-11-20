package morandoso.android.com;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class alimentacao extends AppCompatActivity {

    private RecyclerView mPeopleRV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<alimentacao_feed, alimentacao.NewsViewHolder> mPeopleRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao);
        getSupportActionBar().hide();

        setTitle("alimentacao");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("alimentacao");
        mDatabase.keepSynced(true);

        mPeopleRV = (RecyclerView) findViewById(R.id.aliment_recycler);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("alimentacao");
        Query personsQuery = personsRef.orderByKey();

        mPeopleRV.hasFixedSize();
        mPeopleRV.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<alimentacao_feed>().setQuery(personsQuery, alimentacao_feed.class).build();

        mPeopleRVAdapter = new FirebaseRecyclerAdapter<alimentacao_feed, alimentacao.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(alimentacao.NewsViewHolder holder, final int position, final alimentacao_feed model) {
                holder.setTitulo(model.getTitulo());
                holder.setDesc(model.getDescricao());
                holder.setImagem(getBaseContext(), model.getImagem());

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String url = model.getUrl();
                        Intent intent = new Intent(getApplicationContext(), alimentacao_webview.class);
                        intent.putExtra("id", url);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public alimentacao.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alimentacao_linhas, parent, false);

                return new alimentacao.NewsViewHolder(view);
            }
        };

        mPeopleRV.setAdapter(mPeopleRVAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();


    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public NewsViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setTitulo(String titulo){
            TextView aliment_titulo = (TextView)mView.findViewById(R.id.aliment_titulo);
            aliment_titulo.setText(titulo);
        }
        public void setDesc(String descricao){
            TextView aliment_desc = (TextView)mView.findViewById(R.id.aliment_desc);
            aliment_desc.setText(descricao);
        }
        public void setImagem(Context ctx, String imagem){
            ImageView aliment_imagem = (ImageView) mView.findViewById(R.id.aliment_imagem);
            Picasso.get().load("imagem").into(aliment_imagem);
        }
    }
}
