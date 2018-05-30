        package br.com.senacrs.appcrudcontatosdao.adapter;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.List;

        import br.com.senacrs.appcrudcontatosdao.R;
        import br.com.senacrs.appcrudcontatosdao.model.Contato;

        public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder>
        {

            private List<Contato> listaContatos;
            private Context contexto;
            private ContatoOnClickListener contatoOnClickListener;

            public ContatoAdapter(Context contexto, List<Contato> listaContatos, ContatoOnClickListener contatoOnClickListener) {
                this.contexto = contexto;
                this.listaContatos = listaContatos;
                this.contatoOnClickListener = contatoOnClickListener;
            }

            public void setListaContatos(List<Contato> listaContatos) {
                this.listaContatos = listaContatos;
            }

            @Override
            public ContatoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_contato,parent,false );
                ViewHolder viewHolder = new ViewHolder(view);

                return viewHolder;
            }

            @Override
            public void onBindViewHolder(final ContatoAdapter.ViewHolder holder, final int position) {
                    holder.imagePessoa.setImageResource(listaContatos.get(position).getImagemR());
                    holder.textNome.setText(listaContatos.get(position).getNome());
                    holder.textTelefone.setText(listaContatos.get(position).getTelefone());

                    holder.itemView.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                                    contatoOnClickListener.onClickContato(holder.itemView, position);
                                }
                            });

            }

            @Override
            public int getItemCount() {
                return listaContatos.size();
            }


            public static class ViewHolder extends RecyclerView.ViewHolder{
                public ImageView imagePessoa;
                public TextView textNome;
                public TextView textTelefone;
                public ViewHolder(View view) {
                        super(view);
                        this.imagePessoa = view.findViewById(R.id.imagePessoa);
                        this.textNome = view.findViewById(R.id.textNome);
                        this.textTelefone = view.findViewById(R.id.textTelefone);

                }
            }

            public interface ContatoOnClickListener{
                public void onClickContato(View view, int pos);
            }

        }
