package com.example.myapplicationwithpaging3.adapter.pagingnation


class PaginationBaseAdapter
/*PagingDataAdapter<UserDataModel, PaginationBaseAdapter.MyViewHolder>(DiffUtilCallBack()),
Parcelable {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

    val binding: ViewDataBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.item_layout,
        parent,
        false
    )
    return MyViewHolder(binding)

}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(getItem(position)!!)
}


inner class MyViewHolder(private var binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Any) {

        if ((binding is ItemLayoutBinding)) {
            var userDataModel: UserDataModel = item as UserDataModel
          //  binding.setVariable(BR.data, userDataModel)
        }

    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<UserDataModel>() {
    override fun areItemsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean {
        return oldItem.first_name == newItem.first_name
    }

    override fun areContentsTheSame(oldItem: UserDataModel, newItem: UserDataModel): Boolean {
        return oldItem == newItem
    }
}*/


