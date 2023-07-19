package com.example.back_end_cinemaproject;

import com.example.back_end_cinemaproject.repositories.*;
import com.example.back_end_cinemaproject.security.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.back_end_cinemaproject.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackEndCinemaProjectApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Autowired
    private UserService userService;
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private IBranchRepository branchRepository;
    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private ISeatRepository seatRepository;

    @PostConstruct
    public void init() {


        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            User user = new User();
            Set<Role> roles = new HashSet<>();
            Role roleUser = new Role();
            roleUser.setName("ROLE_CLIENT");
            roles.add(roleUser);
            user.setFullName("Client");
            user.setUsername("client@gmail.com");
            user.setPassword("123");
            user.setRoles(roles);
            userService.save(user);

            User admin = new User();
            Set<Role> roles2 = new HashSet<>();
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roles2.add(roleAdmin);
            admin.setFullName("Admin");
            admin.setUsername("admin@gmail.com");
            admin.setPassword("123");
            admin.setRoles(roles2);
            userService.save(admin);
        }

        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Movie johnWich = addNewMovie("John Wick: Chapter 4", "https://image.tmdb.org/t/p/w342/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg",
                    "Với cái giá phải trả ngày càng tăng, John Wick tham gia cuộc chiến chống lại High Table trên toàn cầu khi tìm kiếm những người chơi quyền lực nhất trong thế giới ngầm, từ New York qua Paris, Osaka đến cả Berlin.",
                    "Với cái giá phải trả ngày càng tăng, John Wick tham gia cuộc chiến chống lại High Table trên toàn cầu khi tìm kiếm những người chơi quyền lực nhất trong thế giới ngầm, từ New York qua Paris, Osaka đến cả Berlin.",
                    "https://congluan-cdn.congluan.vn/files/content/2022/04/26/john-wick-4-tung-poster-hap-dan-hua-hen-man-tro-lai-hoanh-trang-192706965.jpg",
                    "Chad Stahelski", "Keanu Reeves, Scott Adkins, Chan Tu Dan",
                    "Hành động", LocalDate.parse("24/03/2023", formatter),
                    155, "https://youtu.be/yjRHZEUamCc",
                    "Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt",
                    "C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI", 1);

            Movie duaXe = addNewMovie("FAST AND FURIOUS X", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/7/0/700x1000-fastx_1.jpg",
                    "Dom Toretto và gia đình của anh ấy bị trở thành mục tiêu của người con trai đầy thù hận của ông trùm ma túy Hernan Reyes.",
                    "Dom Toretto và gia đình của anh ấy bị trở thành mục tiêu của người con trai đầy thù hận của ông trùm ma túy Hernan Reyes.",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/9/8/980x448-min_f10.jpg",
                    " Louis Leterrier", "Vin Diesel, Jason Momoa, Brie Larson,…",
                    "Hành Động, Tội phạm", LocalDate.parse("19/05/2023", formatter),
                    145, "https://www.youtube.com/embed/Jphd23nUCLs",
                    "Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt",
                    "C16 - PHIM CẤM KHÁN GIẢ DƯỚI 16 TUỔI", 1);

            Movie doremon = addNewMovie("DORAEMON: NOBITA VÀ VÙNG ĐẤT LÝ TƯỞNG TRÊN BẦU TRỜI", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/m/a/main_poster_-_dmmovie2023.jpg",
                    "câu chuyện khi Nobita tìm thấy một hòn đảo hình lưỡi liềm trên trời mây. Ở nơi đó, tất cả đều hoàn hảo… đến mức cậu nhóc Nobita mê ngủ ngày cũng có thể trở thành một thần đồng toán học, một siêu sao thể thao. ",
                    "câu chuyện khi Nobita tìm thấy một hòn đảo hình lưỡi liềm trên trời mây. Ở nơi đó, tất cả đều hoàn hảo… đến mức cậu nhóc Nobita mê ngủ ngày cũng có thể trở thành một thần đồng toán học, một siêu sao thể thao. ",
                    "https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/horizontal_poster-4b6d56d67d25-1683532525591-w9BMN4Y3.jpg?v=0&maxW=600",
                    "Takumi Doyama", "Doraemon, Nobita",
                    "Hoạt hình", LocalDate.parse("26/05/2023", formatter),
                    145, "https://www.youtube.com/embed/SthaOnp5uDs",
                    "Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt",
                    "P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG", 1);

            Movie vayHam = addNewMovie("VÂY HÃM: KHÔNG LỐI THOÁT", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/l/a/launching_poster-art-4x5.jpg",
                    "Quái vật cơ bắp Seok-do (Ma Dong Seok) dẫn đầu đội hình sự truy lùng đường dây buôn chất cấm của thiếu gia Joo Seong Cheol.",
                    "Quái vật cơ bắp Seok-do (Ma Dong Seok) dẫn đầu đội hình sự truy lùng đường dây buôn chất cấm của thiếu gia Joo Seong Cheol.",
                    "https://i.ytimg.com/vi/tbZ-BmOBsuc/maxresdefault.jpg",
                    "Lee Sang Young", "Ma Dong Seok, Lee Joon Hyuk. Munetake Aoki, Lee Beom Soo",
                    "Hành Động, Tội phạm", LocalDate.parse("02/06/2023", formatter),
                    105, "https://www.youtube.com/embed/tbZ-BmOBsuc",
                    "Tiếng Hàn - Phụ đề tiếng Việt",
                    "C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI", 1);

            Movie tienCa = addNewMovie("NÀNG TIÊN CÁ", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/l/t/ltmer_007c_g_vie-vn_4x5_.jpg",
                    "Nàng Tiên Cá là câu chuyện được yêu thích về Ariel - một nàng tiên cá trẻ xinh đẹp và mạnh mẽ với khát khao phiêu lưu.",
                    "Nàng Tiên Cá là câu chuyện được yêu thích về Ariel - một nàng tiên cá trẻ xinh đẹp và mạnh mẽ với khát khao phiêu lưu.",
                    "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2023/02/phim-nang-tien-ca-hay-nhat-mermaid-movies-1-696x392.jpg?fit=700%2C20000&quality=95&ssl=1",
                    "Rob Marshall", " Halle Bailey, Jonah Hauer-King, Daveed Diggs",
                    "Phiêu Lưu", LocalDate.parse("26/05/2023", formatter),
                    135, "https://www.youtube.com/embed/R2cjgaopZcg",
                    "Tiếng Anh - Phụ đề Tiếng Việt",
                    "C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI", 1);

            Movie veBinh = addNewMovie("VỆ BINH DẢI NGÂN HÀ 3", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/3/5/350x495_1.png",
                    "Cho dù vũ trụ này có bao la đến đâu, các Vệ Binh của chúng ta cũng không thể trốn chạy mãi mãi. Họ phải cố gắng để giành lại hành phúc cho mình và gia đình",
                    "Cho dù vũ trụ này có bao la đến đâu, các Vệ Binh của chúng ta cũng không thể trốn chạy mãi mãi. Họ phải cố gắng để giành lại hành phúc cho mình và gia đình",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/6/4/640x396_1_-min.png",
                    " James Gunn", " Chris Pratt, Zoe Saldana, Dave Bautista",
                    "Hành Động, Phiêu Lưu, Thần thoại", LocalDate.parse("03/05/2023", formatter),
                    149, "https://www.youtube.com/embed/O402pXqj79c",
                    "Tiếng Anh - Phụ đề Tiếng Việt",
                    "C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI", 1);

            Movie nguoiNhen = addNewMovie("DU HÀNH VŨ TRỤ NHỆN", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/r/s/rsz_spiderverse2_poster_4.jpg",
                    "Sau khi gặp lại Gwen Stacy, chàng Spider-Man thân thiện đến từ Brooklyn phải du hành qua đa vũ trụ và gặp một nhóm Người Nhện chịu trách nhiệm bảo vệ các vũ trụ song song. ",
                    "Sau khi gặp lại Gwen Stacy, chàng Spider-Man thân thiện đến từ Brooklyn phải du hành qua đa vũ trụ và gặp một nhóm Người Nhện chịu trách nhiệm bảo vệ các vũ trụ song song. ",
                    "https://touchcinema.com/storage/slider-app/2048x682-1684396421946.jpg",
                    "Joaquim Dos Santos, Justin K. Thompson, Kemp Powers", "Shameik Moore",
                    "Hoạt Hình", LocalDate.parse("01/06/2023", formatter),
                    145, "https://www.youtube.com/embed/SUz8Aw28vrc",
                    "Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt",
                    "P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG", 1);
            // Tạo mới các chi nhánh
            List<Branch> listBranch = branchRepository.findAll();
            if (listBranch.isEmpty()) {
                Branch branch1 = new Branch();
                branch1.setName("CGV Vincom Thủ Đức");
                branch1.setDiaChi("Tầng 5, TTTM Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
                branch1.setPhoneNo("+84 4 6 275 5240");
                branch1.setImgURL("https://www.google.com/maps/vt/data=c5ZoHGqgjAJTKD_7LlDj4KA97z32KNwc0VSogtWFjePBI-w_qdB1FG5DGeFetrSNhjTd9m0qArLT0Ejn8OWJsC5LOwjBzRkUixEmA8kXjEIjO6pYQTV0JiiHu5fD__TnqT8slpP17HTZZLEVLCRkf8kOG_nGseMogcfdju6LfjImSkiGFUDr2zyI-TjEeXc");
                branch1 = branchRepository.save(branch1);

                Room room1 = new Room();
                room1.setName("Phòng 101");
                room1.setBranch(branch1);
                room1.setCapacity(40);
                room1.setImgURL("https://storage.clingme.vn/storage/file_1521515326_101960779.jpg?imageWidth=562");
                Room r1 = roomRepository.save(room1);

                Schedule schedule1 = new Schedule();
                schedule1.setBranch(branch1);
                schedule1.setMovie(nguoiNhen);
                schedule1.setRoom(r1);
                schedule1.setStartDate(LocalDate.parse("2023-05-23"));
                schedule1.setStartTime(LocalTime.parse("10:15"));
                schedule1.setPrice(70000);
                scheduleRepository.save(schedule1);

                Schedule schedule2 = new Schedule();
                schedule2.setBranch(branch1);
                schedule2.setMovie(nguoiNhen);
                schedule2.setRoom(r1);
                schedule2.setStartDate(LocalDate.parse("2023-05-23"));
                schedule2.setStartTime(LocalTime.parse("11:15"));
                schedule2.setPrice(70000);
                scheduleRepository.save(schedule2);

                Schedule schedule3 = new Schedule();
                schedule3.setBranch(branch1);
                schedule3.setMovie(nguoiNhen);
                schedule3.setRoom(r1);
                schedule3.setStartDate(LocalDate.parse("2023-05-23"));
                schedule3.setStartTime(LocalTime.parse("12:15"));
                schedule3.setPrice(70000);
                scheduleRepository.save(schedule3);

                Schedule schedule4 = new Schedule();
                schedule4.setBranch(branch1);
                schedule4.setMovie(veBinh);
                schedule4.setRoom(r1);
                schedule4.setStartDate(LocalDate.parse("2023-05-23"));
                schedule4.setStartTime(LocalTime.parse("13:15"));
                schedule4.setPrice(70000);
                scheduleRepository.save(schedule4);

                Schedule schedule5 = new Schedule();
                schedule5.setBranch(branch1);
                schedule5.setMovie(veBinh);
                schedule5.setRoom(r1);
                schedule5.setStartDate(LocalDate.parse("2023-05-23"));
                schedule5.setStartTime(LocalTime.parse("14:15"));
                schedule5.setPrice(70000);
                scheduleRepository.save(schedule5);

                Schedule schedule6 = new Schedule();
                schedule6.setBranch(branch1);
                schedule6.setMovie(veBinh);
                schedule6.setRoom(r1);
                schedule6.setStartDate(LocalDate.parse("2023-05-23"));
                schedule6.setStartTime(LocalTime.parse("15:15"));
                schedule6.setPrice(70000);
                scheduleRepository.save(schedule6);

                Schedule schedule7 = new Schedule();
                schedule7.setBranch(branch1);
                schedule7.setMovie(tienCa);
                schedule7.setRoom(r1);
                schedule7.setStartDate(LocalDate.parse("2023-05-23"));
                schedule7.setStartTime(LocalTime.parse("16:15"));
                schedule7.setPrice(70000);
                scheduleRepository.save(schedule7);

                Branch branch2 = new Branch();
                branch2.setName("CGV Thảo Điền Pearl");
                branch2.setDiaChi("Tầng 2, Thảo Điền Mall, 12 Quốc Hương, Phường Thảo Điền, Quận 1, TP. Hồ Chí Minh");
                branch2.setPhoneNo("1900 6017");
                branch2.setImgURL("https://www.google.com/maps/vt/data=6TcLQVyXF1p1HKKv0q7xJmo4ELdrmOQGAtCkPyfMwQFCXwRG6kr7HsYz3DZlny0XHQoGNobAAkx5tNZoTQnnQkrWACYjpzrseF4YyV5zsLz9R6pfS1qMZddn_-jtle-886S9cmgOm37QIgG9-mlbph9G55Aos7kFdBGnkdQYlHcN3zOB-xKCKfaV5LJI358");
                branch2 = branchRepository.save(branch2);
                room1.setBranch(branch2);
                Room r5 = roomRepository.save(room1);

                Schedule schedule13 = new Schedule();
                schedule13.setBranch(branch2);
                schedule13.setMovie(tienCa);
                schedule13.setRoom(r5);
                schedule13.setStartDate(LocalDate.parse("2023-05-23"));
                schedule13.setStartTime(LocalTime.parse("10:15"));
                schedule13.setPrice(70000);
                scheduleRepository.save(schedule13);
            }
        }
        List<Seat> seats = seatRepository.findAll();
        if (seats.isEmpty()) {
            Room room = roomRepository.findById(1).get();

            for (int i = 1; i <= 8; i++) {
                Seat seat = new Seat();
                seat.setName("A" + i);
                seat.setRoom(room);
                seatRepository.save(seat);
            }

            for (int i = 1; i <= 8; i++) {
                Seat seat = new Seat();
                seat.setName("B" + i);
                seat.setRoom(room);
                seatRepository.save(seat);
            }
            for (int i = 1; i <= 8; i++) {
                Seat seat = new Seat();
                seat.setName("C" + i);
                seat.setRoom(room);
                seatRepository.save(seat);
            }
            for (int i = 1; i <= 8; i++) {
                Seat seat = new Seat();
                seat.setName("D" + i);
                seat.setRoom(room);
                seatRepository.save(seat);
            }
            for (int i = 1; i <= 8; i++) {
                Seat seat = new Seat();
                seat.setName("E" + i);
                seat.setRoom(room);
                seatRepository.save(seat);
            }
        }
    }

    public Movie addNewMovie(
            String name,
            String smallImageURl,
            String shortDescription,
            String longDescription,
            String largeImageURL,
            String director,
            String actors,
            String categories,
            LocalDate releaseDate,
            int duration,
            String trailerURL,
            String language,
            String rated,
            int isShowing) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setSmallImageURl(smallImageURl);
        movie.setShortDescription(shortDescription);
        movie.setLongDescription(longDescription);
        movie.setLargeImageURL(largeImageURL);
        movie.setDirector(director);
        movie.setActors(actors);
        movie.setCategories(categories);
        movie.setReleaseDate(releaseDate);
        movie.setDuration(duration);
        movie.setTrailerURL(trailerURL);
        movie.setLanguage(language);
        movie.setRated(rated);
        movie.setIsShowing(isShowing);
        movie = movieRepository.save(movie);
        return movie;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackEndCinemaProjectApplication.class, args);
    }

}
