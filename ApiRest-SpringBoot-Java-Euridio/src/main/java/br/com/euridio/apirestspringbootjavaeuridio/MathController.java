package br.com.euridio.apirestspringbootjavaeuridio;

import br.com.euridio.apirestspringbootjavaeuridio.Exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static String template = "hello, %s !";
    private final AtomicLong counter = new AtomicLong();



    @RequestMapping(value = "/sum/{numberOne}/{numbertwo}",method = RequestMethod.GET)
    public Double EndpointSum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numbertwo") String numbertwo) throws Exception {
        return  ConvertDouble(numberOne)+ConvertDouble(numbertwo);
    }
    @RequestMapping(value = "/subtraction/{numberOne}/{numbertwo}",method = RequestMethod.GET)
    public Double Endpointsubtraction(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numbertwo") String numbertwo) throws Exception {
        var ret = ConvertDouble(numberOne)-ConvertDouble(numbertwo);
        if(ret <=0)
            return 0D;

        return  ret;
    }
//    @RequestMapping(value = "/sum/{numberOne}/{numbertwo}",method = RequestMethod.GET)
//    public Double EndpointSum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numbertwo") String numbertwo) throws Exception {
//        return  ConvertDouble(numberOne)+ConvertDouble(numbertwo);
//    }
//    @RequestMapping(value = "/sum/{numberOne}/{numbertwo}",method = RequestMethod.GET)
//    public Double EndpointSum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numbertwo") String numbertwo) throws Exception {
//        return  ConvertDouble(numberOne)+ConvertDouble(numbertwo);
//    }

    private Double ConvertDouble(String number) throws Exception {
        if(number == null)
            return 0D;

        var numberAtualizado = number.replace(",",".");

        if (!isNumeric(numberAtualizado))
            throw new UnsupportedMathOperationException("valor não numerico");

        return Double.parseDouble(numberAtualizado);
    }

    private boolean isNumeric(String number) {
        try{
            Double.parseDouble(number);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
