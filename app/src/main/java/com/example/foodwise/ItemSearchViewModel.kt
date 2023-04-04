//package com.example.foodwise
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//
//import com.google.android.gms.cast.tv.cac.UserAction
//
//
//class ItemSearchViewModel:ViewModel() {
//var state by mutableStateOf(ItemSearchState())
//
//    fun onAction(userAction: UserAction){
//        when(userAction){
//            UserAction.SearchIconClicked-> TODO()
//            UserAction. CloseIconClicked-> TODO()
//        }
//    }
//
//}
//
//sealed class UserAction {
//    object SearchIconClicked : UserAction()
//    object CloseIconClicked : UserAction()
//}
//
//
//data class ItemSearchState(
//    val isSearchBarVisible:Boolean=false
//)