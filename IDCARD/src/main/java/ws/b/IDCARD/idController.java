/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.IDCARD;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lenovo
 */
@Controller
public class idController { 
    
    @RequestMapping(value = "/tampildata", method = RequestMethod.POST)
    public String getData (@RequestParam (value = "varnama") String N,
                        @RequestParam (value = "vartgl") String T,
                        @RequestParam (value = "varjk") String J,
                        @RequestParam (value = "varalamat") String Al,
                        @RequestParam (value = "varagama") String Ag,
                        @RequestParam (value = "varkerja") String K,
                        @RequestParam (value = "varnegara") String Neg,
                        @RequestParam (value = "varfoto") MultipartFile F,
                        ModelMap modelMap) throws IOException{ 
        
        byte[] fotoktp = F.getBytes();
        String base64image = Base64.encodeBase64String(fotoktp);
        String addfoto ="data:image/png;base64,".concat(base64image);      
        String a;     
            a = "Nama Lengkap  : ";
        String b;        
            b = "Tanggal Lahir : ";
        String c;     
            c = "Jenis Kelamin  : ";
        String d;        
            d = "Alamat : ";            
        String e;        
            e = "Agama : ";            
        String f;     
            f = "Pekerjaan  : ";
        String g;        
            g = "Kewarganegaraan : ";
            
        modelMap.addAttribute("inama", a + N);
        modelMap.addAttribute("itgl", b + T);
        
        modelMap.addAttribute("ijk", c + J);
        modelMap.addAttribute("ialamat", d + Al);   
        modelMap.addAttribute("iagama", e + Ag);
        modelMap.addAttribute("ikerja", f + K);        
        modelMap.addAttribute("inegara", g + Neg);
       
        modelMap.addAttribute("ifoto", addfoto);
        return "display";
    }
}
