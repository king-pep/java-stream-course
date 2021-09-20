package exercises;

import beans.Car;
import beans.Person;
import mockdata.MockData;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

public class MoreExercises {
  // TODO: Coming soon

    //stream terminal operations

    @Test
    public void streamTest() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Car> cars = MockData.getCars();
        people.stream().map(p -> p.getEmail().toUpperCase()).limit(5).forEach(System.out::println);
      boolean ans =  cars.stream().anyMatch( p-> p.getYear() == 2010);//forEach(System.out::println);
        System.out.println(ans);
        Optional<Double> carPrices = cars.stream().map(c -> c.getPrice()).reduce((a, b) -> a + b);
        System.out.println(carPrices.get());

    }

    @Test
    public void Base64Test() throws Exception {
        String encodedString = "This is Base64 encoding and decoding example";
        Base64 base64 = new Base64();
        String encodedVersion = new String(base64.encode(encodedString.getBytes()));
        System.out.println("Encoded Version is " + encodedVersion);
        String decodedVersion = new String(base64.decode(encodedVersion.getBytes()));
        System.out.println("Decoded version is "+ decodedVersion);


        Base64 binaryBase64 = new Base64();
        Random binaryRandomData = new Random();
        byte[] binaryRandomBytes = new byte[32];
        binaryRandomData.nextBytes(binaryRandomBytes);


        String dataInternalVersion =  new String(binaryBase64.encodeBase64(binaryRandomBytes));
        System.out.println("Encoded version of binary data is " + dataInternalVersion);
        String decodedData = new String(binaryBase64.decodeBase64(dataInternalVersion));
    }
}
