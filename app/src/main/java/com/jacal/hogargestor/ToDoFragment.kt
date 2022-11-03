package com.jacal.hogargestor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.jacal.hogargestor.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ToDoFragment: Fragment() {
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter : RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>
    var myTaskTitles: ArrayList<String> = ArrayList()
    var myTaskTimes: ArrayList<String> = ArrayList()
    var myTaskPlaces: ArrayList<String> = ArrayList()
    var myTaskIds: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento=inflater.inflate(R.layout.fragment_to_do,container,false)
        /*val detail1: Button =fragmento.findViewById(R.id.btn_detail1)
        val detail2: Button =fragmento.findViewById(R.id.btn_detail2)
        val detail3: Button =fragmento.findViewById(R.id.btn_detail3)
        val detail4: Button =fragmento.findViewById(R.id.btn_detail4)
        val detail5: Button =fragmento.findViewById(R.id.btn_detail5)
        val detail6: Button =fragmento.findViewById(R.id.btn_detail6)
        val detail7: Button =fragmento.findViewById(R.id.btn_detail7)
        detail1.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
                datos.putString("tarea","Registrar Niños")
                datos.putString("hora","07:21 AM")
                datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
            })
        detail2.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Asignar Pediatra y Nutricionista a Niños")
            datos.putString("hora","08:34 AM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })
        detail3.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Registar Patrones de Crecimiento")
            datos.putString("hora","17:02 PM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })
        detail4.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Historial Crecimiento")
            datos.putString("hora","14:15 PM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })
        detail5.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Consulta Pediatra y Nutricionista")
            datos.putString("hora","14:15 PM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })
        detail6.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Analizar Datos")
            datos.putString("hora","11:37 AM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })
        detail7.setOnClickListener(View.OnClickListener{
            val datos=Bundle()
            datos.putString("tarea","Historial Cuidado del Niño")
            datos.putString("hora","14:15 PM")
            datos.putString("lugar","Valledupar")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,Detailfragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        })*/
        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /*
        myTaskTitles.add("ir al supermercado")
        myTaskTitles.add("Lleva carro a tecnomecanica")
        myTaskTitles.add("Cita Medica")
        myTaskTitles.add("Tarea 4")

        myTaskTimes.add("16:00pm")
        myTaskTimes.add("12:00pm")
        myTaskTimes.add("11:00am")
        myTaskTimes.add("02:00pm")

        myTaskPlaces.add("Lugar 1")
        myTaskPlaces.add("Lugar 2")
        myTaskPlaces.add("Lugar 3")
        myTaskPlaces.add("Lugar 4")
        var info: Bundle=Bundle()
        info.putStringArrayList("titles",myTaskTitles)
        info.putStringArrayList("times",myTaskTimes)
        info.putStringArrayList("places",myTaskPlaces)
        listRecyclerView=requireView().findViewById(R.id.reciclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter= myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))*/
        val fab :View = requireActivity().findViewById(R.id.fab2)
        fab.setOnClickListener { view ->
            val intent = Intent(activity, NewTaskActivity::class.java)
            var recursiveScope = 0
            startActivityForResult(intent, recursiveScope)
        }
        var info: Bundle=Bundle()
        info.putStringArrayList("titles",myTaskTitles)
        info.putStringArrayList("times",myTaskTimes)
        info.putStringArrayList("places",myTaskPlaces)
        info.putStringArrayList("ids",myTaskIds)
        listRecyclerView=requireView().findViewById(R.id.reciclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter= myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        updateList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if(requestCode==0){
           if(resultCode==Activity.RESULT_OK){
               updateList()
           }
       }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun updateList(){
        val db = ToDoDatabase.getDatabase(requireActivity())
        val toDoDAD = db.todoDao()
        runBlocking {
            launch {
                var result = toDoDAD.getAllTasks()
                var i=0
                myTaskTitles.clear()
                myTaskTimes.clear()
                myTaskPlaces.clear()
                myTaskIds.clear()
                while(i<result.size){
                    myTaskTitles.add(result[i].title.toString())
                    myTaskTimes.add(result[i].time.toString())
                    myTaskPlaces.add(result[i].place)
                    val add = myTaskIds.add(
                        result[i].id.toString()
                                i ++
                }
                myAdapter.notifyDataSetChanged()
            }
        }
    }
}