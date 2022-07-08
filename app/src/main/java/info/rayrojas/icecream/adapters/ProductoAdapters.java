package info.rayrojas.icecream.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import info.rayrojas.icecream.R;
import info.rayrojas.icecream.models.Productos;

    public class ProductoAdapter extends ArrayAdapter<Productos> {
        Context context;
        private class ViewHolder {
            TextView name;
            TextView nickname;

            private ViewHolder() {
            }
        }
        public ProductoAdapter(Context context, List<Productos> items) {
            super(context, 0, items);
            this.context = context;
        }
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            final Productos rowItem = (Productos) getItem(position);
            LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.productos_item,null);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.nickname = (TextView) convertView.findViewById(R.id.nickname);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.name.setText(rowItem.name);
            holder.nickname.setText(rowItem.nickname);
            return convertView;
        }
}
