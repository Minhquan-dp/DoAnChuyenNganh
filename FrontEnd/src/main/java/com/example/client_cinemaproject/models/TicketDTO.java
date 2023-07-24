package com.example.client_cinemaproject.models;

import lombok.Data;
// annotation @Data tự động tạo các getter, setter,
// phương thức toString(), equals(), và hashCode()
// dựa trên các thuộc tính đã khai báo
@Data
public class TicketDTO {
    private int id;
    private String qrImageURL;
    private ScheduleDTO schedule;
    private SeatDTO seat;
    private BillDTO bill;
}
