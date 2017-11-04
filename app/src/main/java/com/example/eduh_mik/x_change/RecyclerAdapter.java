package com.example.eduh_mik.x_change;

/**
 * Created by Eduh_mik on 11/1/2017.
 */
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] titles = {
            "NIGERIAN NAIRA-NGN",
            "UNITED STATES DOLLAR-USD",
            "EURO-EUR",
            "CHINA YUAN-CNY",
            "BRITISH POUND-GBP",
            "JAPANESE YEN-JPY",
            "CANADIAN DOLLAR-CAD",
            "SINGAPORE DOLLAR-SGD",
            "POLISH ZLOTY-PLN",
            "AUSTRALIAN DOLLAR-AUD",
            "HONGKONG DOLLAR-HKD",
            "RUSSIAN RUBBLE-RUB",
            "INDIAN RUPEE-INR",
            "SOUTH AFRICAN RAND-ZAR",
            "SWISS FRANC-CHF",
            "PHILIPPINE PESO-PHP",
            "KENYAN SHILLING-KES",
            "UGANDAN SHILLING-UGX",
            "ISRAEL SHEKEL-ILS",
            "BRAZILIAN REAL-BRL"};
    private String[] details=  {
            "2552973.71",
            "6963.06",
            "6097.57",
            "46940.84",
            "5315.57",
            "791107.98",
            "9264.36",
            "9493.65",
            "25036.88",
            "9303.84",
            "54965.13",
            "408434.09",
            "485998.44",
            "118754.70",
            "6984.94",
            "357490.06",
            "761789.66",
            "27045271.62",
            "24249.01",
            "23822.00"};
    private int[] images = {R.drawable.ngn,
            R.drawable.usd,
            R.drawable.eur,
            R.drawable.cny,
            R.drawable.gbp,
            R.drawable.jpy,
            R.drawable.cad,
            R.drawable.sgd,
            R.drawable.pln,
            R.drawable.aud,
            R.drawable.hkd,
            R.drawable.rub,
            R.drawable.inr,
            R.drawable.zar,
            R.drawable.chf,
            R.drawable.php,
            R.drawable.kes,
            R.drawable.ugx,
            R.drawable.ils,
            R.drawable.brl};

    class ViewHolder extends RecyclerView.ViewHolder{
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(final View itemView){
           super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(itemView.getContext(), conversion.class);
                    intent.putExtra("title", itemTitle.getText().toString());
                    intent.putExtra("detail", itemDetail.getText().toString());

                    itemView.getContext().startActivity(intent);
                    Snackbar.make(v, "Click detected on item" + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            }

            );
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_recyclerview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (ViewHolder viewHolder, int i){
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }
    @Override
    public int getItemCount() {
        return titles.length; }
}
