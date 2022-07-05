package com.example.expandablelistviewone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.expandablelistviewone.R

class ExpandableAdapter(var titleList: List<String>, var map: HashMap<String, List<String>>) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): String {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        val list = map[titleList[groupPosition]]

        return list!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {

        return groupPosition.toLong()

    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {

        return childPosition.toLong()

    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var groupItemView: View

        if (convertView == null) {

            groupItemView =
                LayoutInflater.from(parent!!.context).inflate(R.layout.group_item, parent, false)

        } else {

            groupItemView = convertView

        }

        groupItemView.findViewById<TextView>(R.id.group_text_id).text = titleList[groupPosition]

        return groupItemView

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var childItemView:View
        if (convertView == null){

            childItemView = LayoutInflater.from(parent!!.context).inflate(R.layout.child_item,parent,false)

        }else{

            childItemView = convertView

        }

        childItemView.findViewById<TextView>(R.id.child_text_id).text = map[titleList[groupPosition]]!![childPosition]

        return childItemView

    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}