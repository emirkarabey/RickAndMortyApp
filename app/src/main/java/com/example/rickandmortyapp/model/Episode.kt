package com.example.rickandmortyapp.model

data class EpisodeList(val info: EpisodeInfo,val results:List<EpisodeData>)
data class EpisodeData(val name:String?,val episode:String?,val created:String?)
data class EpisodeInfo(val count:Int?,val pages:String?,val next:String?,val prev:String?)