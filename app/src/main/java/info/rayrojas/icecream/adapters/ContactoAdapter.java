package info.rayrojas.icecream.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import info.rayrojas.icecream.R;
import info.rayrojas.icecream.models.Contacto;

public class ContactoAdapter extends ArrayAdapter<Contacto> {
  Context context;
  private class ViewHolder {
    TextView firstName;
    TextView lastName;

    private ViewHolder() {
    }
  }
  public ContactoAdapter(Context context, List<Contacto> items) {
    super(context, 0, items);
    this.context = context;
  }
  public View getView(final int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    final Contacto rowItem = (Contacto) getItem(position);
    LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null) {
      convertView = mInflater.inflate(R.layout.contacto_item, null);
      holder = new ViewHolder();
      holder.firstName = (TextView) convertView.findViewById(R.id.firstName);
      holder.lastName = (TextView) convertView.findViewById(R.id.lastName);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    holder.firstName.setText(rowItem.firstName);
    holder.lastName.setText(rowItem.lastName);
    return convertView;
  }
}