package com.example.eduh_mik.x_change;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ethAdapter extends RecyclerView.Adapter<ethAdapter.ViewHolder> {

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
            "103475.88",
            "300.77",
            "262.88",
            "1907.01",
            "226.32",
            "33960.02",
            "389.51",
            "403.01",
            "1112.49",
            "399.12",
            "2353.80",
            "17112.59",
            "20020.73",
            "29372.51",
            "309.12",
            "15485.83",
            "43067.41",
            "303761.90",
            "770.62",
            "705.83"};
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

    class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image2);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title2);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(itemView.getContext(), conversion2.class);
                    intent.putExtra("title", itemTitle.getText().toString());
                    intent.putExtra("detail", (itemDetail.getText().toString()));
                    itemView.getContext().startActivity(intent);
                    Snackbar.make(v, "Click detected on item" + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ethcontents, viewGroup, false);
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
