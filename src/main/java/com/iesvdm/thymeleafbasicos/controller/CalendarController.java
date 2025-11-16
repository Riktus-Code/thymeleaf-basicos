package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CalculadoraDTO;
import com.iesvdm.thymeleafbasicos.dto.CalendarRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @GetMapping("")
    public String getCalendarForm(Model model, @ModelAttribute CalendarRequestDTO calendarRequestDTO, Locale locale){

         Calendar.getInstance().getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT, new Locale("es"));
        List<String> meses = new ArrayList<>(12);
        Calendar calendar = Calendar.getInstance();
        for (int i =1; i<=12; i++){
            calendar.set(2025,i,0);
            meses.add(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, locale));
        }
        model.addAttribute("meses",meses);
        model.addAttribute("calendarRequestDTO", calendarRequestDTO);

        return "calendar";
    }

    @PostMapping("")
    public String calcularMes(Model model, @ModelAttribute CalendarRequestDTO calendarRequestDTO, Locale locale){

        String mes = calendarRequestDTO.getMes();

        int mesNum =  convertirMesAEntero(mes);

        int anio = calendarRequestDTO.getAnio();
        //empezamos siempre en el dia uno del mes del año
        Calendar cal = Calendar.getInstance();
        cal.set(anio,mesNum,1);
        //obtenemos el dia de la semana en que enpiza el mes
        int inicio = cal.get(Calendar.DAY_OF_WEEK);
        //obternemos el  numero total de dias del mes
        int diaMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //cajustamos el incio para calendario de lunes a domingo
        int diaInicio;

        if(inicio == Calendar.SUNDAY){
            diaInicio = 7;
        }else{
            diaInicio = inicio-1;
        }
        //creanis una estructurtas de semanas, las semanas seran una listas de listas
        //y las semanasActuales solo una lista
        //ya quie las semanas pillaran todas las semans del mes y
        //semanasActuales solo son de lunes a domingo
        List<List<String>> semanas = new ArrayList<>();
        List<String> semanasActuales = new ArrayList<>();

        //añadimos huecos al principio
        for (int i = 1; i< diaInicio; i++){
            semanasActuales.add(null);
        }
        //rellenamos los dias del mes
        for (int i = 1; i<=diaMes; i++){
            semanasActuales.add(String.valueOf(i));
            //cuando la semanaActual (esta completa) tiene 7 dias la añadimos a la lista de semanas
            if(semanasActuales.size() == 7){
                semanas.add(semanasActuales);
                semanasActuales = new ArrayList<>();
            }
        }
        //si alguna semana queda vacia le añadimos huecos vacio y la añadimos a semanas
        if(!semanasActuales.isEmpty()){

            while(semanasActuales.size()<7){
               semanasActuales.add(null);
            }
            semanas.add(semanasActuales);
        }
        model.addAttribute("anio",anio);
        model.addAttribute("mesNombre",cal.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, locale));
        model.addAttribute("semanas",semanas);


        return "calendar";
    }

    private int convertirMesAEntero(String mesNumero){
        try{
           int mesNum = Integer.parseInt(mesNumero);
           if(mesNum<1 || mesNum>12){
               throw new RuntimeException("Mes inválido: "+mesNumero);
           }
           return mesNum - 1;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
