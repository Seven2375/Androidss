package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.huangxue.s01.Beans.BusLineListBean;
import com.huangxue.s01.R;

import java.util.List;

public class BusLineListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<BusLineListBean.RowsEntity> partentRows;
    private List<List<String>> childNameList;
    private BusLineListBean.RowsEntity data;

    public BusLineListAdapter(Context mContext, List<BusLineListBean.RowsEntity> partentRows, List<List<String>> childNameList) {
        this.mContext = mContext;
        this.partentRows = partentRows;
        this.childNameList = childNameList;
    }
    //父控件的个数
    @Override
    public int getGroupCount() {
        return partentRows.size();
    }
    //当前父控件的子控件的个数
    @Override
    public int getChildrenCount(int i) {
        return childNameList.get(i).size();
    }
    //获取父控件的数据
    @Override
    public Object getGroup(int i) {
        return partentRows.get(i);
    }
    //获取子控件的数据
    @Override
    public Object getChild(int i, int i1) {
        return childNameList.get(i).get(i1);
    }
    //获取指定分组中的指定子选项数据
    @Override
    public long getGroupId(int i) {
        return i;
    }
    //获取子选项的ID, 这个ID必须是唯一的
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }
    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return false;
    }

/**
 *
 * 获取显示指定组的视图对象
 *
 * @param groupPosition 组位置
 * @param isExpanded 该组是展开状态还是伸缩状态
 * @param convertView 重用已有的视图对象
 * @param parent 返回的视图对象始终依附于的视图组
 */
// 获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        data = partentRows.get(groupPosition);
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_bus_exlist_partent,parent,false);
            holder = new GroupViewHolder();
            holder.lineName = convertView.findViewById(R.id.bus_line_item_partent_name);
            holder.staName = convertView.findViewById(R.id.bus_line_item_partent_staName);
            holder.endName = convertView.findViewById(R.id.bus_line_item_partent_endName);
            holder.price = convertView.findViewById(R.id.bus_line_item_partent_price);
            holder.mileage = convertView.findViewById(R.id.bus_line_item_partent_mileage);
            holder.staTime = convertView.findViewById(R.id.bus_line_item_partent_staTime);
            holder.endTime = convertView.findViewById(R.id.bus_line_item_partent_endTime);
            convertView.setTag(holder);
        }else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.lineName.setText(data.getName());
        holder.staName.setText(data.getFirst());
        holder.endName.setText(data.getEnd());
        holder.price.setText("￥"+ data.getPrice());
        holder.mileage.setText(data.getMileage()+"公里");
        holder.staTime.setText("(首)"+ data.getStartTime());
        holder.endTime.setText("(末)"+ data.getEndTime());
        convertView.findViewById(R.id.bus_line_item_partent_skip).setOnClickListener(view -> {
            if (myOnClick!=null){
                myOnClick.onClick(groupPosition);
            }
        });

        return convertView;
    }

    public interface MyOnClick{
        void onClick(int position);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
/**
 *
 * 获取一个视图对象，显示指定组中的指定子元素数据。
 *
 * @param groupPosition 组位置
 * @param childPosition 子元素位置
 * @param isLastChild 子元素是否处于组中的最后一个
 * @param convertView 重用已有的视图(View)对象
 * @param parent 返回的视图(View)对象始终依附于的视图组
 * @return
 */
    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        String s = childNameList.get(groupPosition).get(childPosition);
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_bus_exlist_child,parent,false);
            holder = new ChildViewHolder();
            holder.Name = convertView.findViewById(R.id.bus_line_item_child_name);
            convertView.setTag(holder);
        }else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        holder.Name.setText(s);

        return convertView;
    }
    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    static class GroupViewHolder{
        TextView lineName;
        TextView staName;
        TextView endName;
        TextView price;
        TextView mileage;
        TextView staTime;
        TextView endTime;
    }
    static class ChildViewHolder{
        TextView Name;
    }
}
