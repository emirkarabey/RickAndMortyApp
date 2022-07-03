package com.example.rickandmortyapp.model

data class LocationList(val info: LocationInfo,val results:List<LocationData>)
data class LocationData(val name:String?,val type:String?,val dimension:String?)
data class LocationInfo(val count:Int?,val pages:String?,val next:String?,val prev:String?)