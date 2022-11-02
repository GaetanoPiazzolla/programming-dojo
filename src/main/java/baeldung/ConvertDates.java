package baeldung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class ConvertDates {

    public static void lol(String[] args) throws ParseException {

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        Date date = isoFormat.parse("2010-05-23T22:01:02");

        java.sql.Date sqlDate;

        // 2010-05-23
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        // 2010-05-24
        TimeZone.setDefault(TimeZone.getTimeZone("Rome"));
        sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        System.out.println(timestamp);
        System.out.println(date);
    }

    public static void lola(String[] args) throws ParseException {
        java.sql.Date sqlDate = new java.sql.Date(0);
        java.time.LocalDate localDate = sqlDate.toLocalDate();
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        Date date = isoFormat.parse("2010-05-23T22:01:02");

        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(date.toInstant().atZone(ZoneId.of("America/Los_Angeles")).toLocalDate());
        // 2010-05-23

        TimeZone.setDefault(TimeZone.getTimeZone("Rome"));
        System.out.println(date.toInstant().atZone(ZoneId.of("America/Los_Angeles")).toLocalDate());
        // 2010-05-23
    }

}
