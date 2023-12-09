package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Appointment;
import com.example.yourdestinyweb.models.Doctor;
import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.repositories.AppointmentRepository;
import com.example.yourdestinyweb.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {
    private final AppointmentRepository cartItemRepository;
    private final DoctorRepository doctorRepository;


//    public ShoppingCartService(CartItemRepository cartItemRepository,
//                               DoctorRepository productRepository) {
//        this.cartItemRepository = cartItemRepository;
//        this.productRepository = productRepository;
//    }
//
//    public List<CartItem> listCartItems(User user) {
//        return cartItemRepository.findByUser(user);
//    }

    public void addAppointment(Doctor doctor, String date, String time) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Appointment appointment = new Appointment();
        Date datetime = new Date();
        try {
            datetime = formatter.parse(date + " " + time);
            appointment.setTime(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (cartItemRepository.getByDoctorAndTime(doctor, datetime) == null) {
            appointment.setDoctor(doctor);
            doctor.addAppointment(appointment);
            doctorRepository.save(doctor);
        }
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.setUser(null);
        appointment.setAvailable(true);
        cartItemRepository.save(appointment);
    }

    public List<Appointment> doctorAppointments(Doctor doctor) {
        return cartItemRepository.findByDoctorAndAvailableOrderByTime(doctor, true);
    }

    public void deleteOld() {
         cartItemRepository.deleteOld();
    }


    public List<Appointment> userAppointments(User user) {
        return cartItemRepository.findByUserOrderByTime(user);
    }


    public void deleteAppointment(Long id) {
        cartItemRepository.deleteById(id);
    }

    public List<Appointment> listAppointments(Doctor doctor) {
        return cartItemRepository.findByDoctorOrderByTime(doctor);
    }

    public void addUser(Appointment appointment, User user) {
        appointment.setUser(user);
        cartItemRepository.save(appointment);
    }

//    public void deleteItem(User user,  Doctor product) {
//        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product);
//        cartItemRepository.delete(cartItem);
//    }
//
//    public void setNewQuantity(User user, Doctor product, int quantity) {
//        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product);
//
//        cartItemRepository.save(cartItem);
//    }
//
//    public void clearCart(User user) {
//
//
//        for (CartItem cartItem : cartItems) {
//            cartItemRepository.delete(cartItem);
//        }
//
//      /*  cartItemRepository.deleteAllByUser(user);*/
//    }

}
