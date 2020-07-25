package br.edu.ifspsaocarlos.agendalivedata.view;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import br.edu.ifspsaocarlos.agendalivedata.model.Contato;
import br.edu.ifspsaocarlos.agendalivedata.R;

import java.util.ArrayList;
import java.util.List;


public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>
implements Filterable {

    private static List<Contato> contatos;

    List<Contato> contactListFiltered;

    private static ItemClickListener clickListener;

   public void setContatos(List<Contato> c){
        contatos = c;
        contactListFiltered=c;
        notifyDataSetChanged();
    }

    public List<Contato> getContactListFiltered()
    {
        return contactListFiltered;
    }



    @Override
    public ContatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contato_celula, parent, false);
        return new ContatoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ContatoViewHolder holder, int position) {
         holder.nome.setText(contactListFiltered.get(position).getNome());


    }

    @Override
    public int getItemCount() {
        if (contactListFiltered != null) {
            return contactListFiltered.size();
        } else return 0;
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        clickListener = itemClickListener;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    contactListFiltered = contatos;
                } else {
                    List<Contato> filteredList = new ArrayList<>();
                    for (Contato row : contatos) {
                        if (row.getNome().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                contactListFiltered = (ArrayList<Contato>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public  class ContatoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView nome;

        ContatoViewHolder(View view) {
            super(view);
            nome = view.findViewById(R.id.nome);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (clickListener != null)
                clickListener.onItemClick(getAdapterPosition());
        }
    }


    public interface ItemClickListener {
        void onItemClick(int position);
    }

}


