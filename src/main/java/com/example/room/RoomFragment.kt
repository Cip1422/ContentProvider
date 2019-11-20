package com.example.room


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
class RoomFragment : Fragment() {

    lateinit var HotelDB: HotelDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        HotelDB = Room.databaseBuilder(
                requireContext(),
                HotelDatabase::class.java,
                "Hotel.db"
        )
                .allowMainThreadQueries()
                .build()

        setUpAdapter()



    }


    private fun setUpAdapter() {
        val adapter = GuestAdapter(HotelDB.HotelDAO().retrieveAllRooms())
        guest_recyclerview.adapter = adapter
        guest_recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

}
