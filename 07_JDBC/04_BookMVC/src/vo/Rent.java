package vo;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor 
@Data
public class Rent {

	private int rentNo;
	private String id; // fk (Client)
	private int bookNo; // fk (Book)
	private LocalDate rentDate;
	
//	private Member member;
	private Book book;
}
