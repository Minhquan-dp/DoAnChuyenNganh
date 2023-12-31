package com.example.back_end_cinemaproject.apis;


import com.example.back_end_cinemaproject.dtos.BookingRequestDTO;
import com.example.back_end_cinemaproject.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bills")
public class BillApi {
    @Autowired
    private BillService billService;

    @PostMapping("/create-new-bill")
    public ResponseEntity<String> createNewBill(@RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            billService.createNewBill(bookingRequestDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Bạn đã mua vé xem phim thành công !", HttpStatus.OK);
    }
}
