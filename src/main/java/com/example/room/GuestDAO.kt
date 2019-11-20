package com.example.room

import androidx.room.*

@Dao
interface HotelDAO {

    @Insert
    fun addNewRoom(HotelEntity: HotelEntity)

    @Query("SELECT * FROM Hotel")

    fun retrieveAllRooms(): List<HotelEntity>







}