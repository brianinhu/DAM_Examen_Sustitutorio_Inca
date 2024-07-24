package com.example.dam_examen_sustitutorio_inca;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth / 180);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("Nacho se despide entre lágrimas de Real Madrid ", "Este club lo es todo para mí, señaló Nacho que jugará en Al Qadsiah después de casi 24 años en Real Madrid.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Elecciones 2026: ¿Las empresas privadas deberían financiar a los partidos políticos?", "Con dos procesos electorales en el 2026, las elecciones generales y las regionales y municipales, las organizaciones políticas se preparan.",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Dennis Schröder, campeón del mundo de baloncesto, será el abanderado de Alemania en el 2024","El basquetbolista estará acompañado de la judoca Anna-Maria Wagner, anunció la Confederación Deportiva Olímpica Alemana.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Congreso verá hoy informe que propone a Enrique Aguilar como contralor general de la República","La Comisión Permanente se reunirá para evaluar el informe final de la subcomisión que indica que César Enrique Aguilar Surichaqui", true,android.R.color.holo_blue_light));
            notaList.add(new Nota("Protestas contra Dina Boluarte: General Arriola asegura que habrá control en buses", "El jefe del Estado Mayor recalcó que se tomará las mismas medidas del año pasado para evitar que hayan desmanes",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Congreso: aprueban informe final sobre propuesta de nuevo contralor general de la República","El grupo de trabajo encargado de la evaluación admitió la postulación de César Enrique Aguilar Surichaqui", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Detectan tiburones intoxicados con cocaína por primera vez en el mundo en Brasil","Un reciente estudio identificó la presencia de cocaína en 13 tiburones a raíz de una probable sobreexposición a una gran cantidad", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Un fallo informático de Crowdstrike y Microsoft a gran escala afectó a una multitud de compañías", "Este apagón cibernético a gran escala afectó aeropuertos, medios de comunicación, bancos y telecomunicaciones",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Momento del ataque de Israel al puerto yemení de Hodeida", "Los ataques de Israel, que provocaron un incendio masivo en la zona portuaria yemení de Hodeida, dejaron al menos 80 heridos",false, android.R.color.holo_green_light));
            adapterNotas = new MyNotaRecyclerViewAdapter(notaList, mListener);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  NotasInteractionListener) {
            mListener = (NotasInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + "Debe implementarse Notas Listener");
        }
    }
}