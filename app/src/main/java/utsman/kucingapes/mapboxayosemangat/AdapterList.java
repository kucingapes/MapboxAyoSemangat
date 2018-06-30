package utsman.kucingapes.mapboxayosemangat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderView>{
    private List<ItemList> itemLists;
    private Context context;

    public AdapterList(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public AdapterList.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        context = parent.getContext();
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.HolderView holder, int position) {
        ItemList list = itemLists.get(position);
        holder.tvJudul.setText(list.getTitle());
        holder.tvSubtitle.setText(list.getSubtitle());
        holder.cardView.setOnClickListener(view -> {
            Toast.makeText(context, list.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class HolderView extends RecyclerView.ViewHolder {
        public TextView tvJudul, tvSubtitle;
        public CardView cardView;
        public HolderView(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.judul);
            tvSubtitle = itemView.findViewById(R.id.subtitle);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
