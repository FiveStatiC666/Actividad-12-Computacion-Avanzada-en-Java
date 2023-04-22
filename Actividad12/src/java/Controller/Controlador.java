package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class Controlador 
{
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public Controlador(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    
    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("triangulo", new Triangulo(0,0,0,0));
        return "index";
    }
    
    @PostMapping("/calcular")
    public String calcular(@ModelAttribute Triangulo triangulo, Model model)
    {
        int base=triangulo.getBase();
        int altura=triangulo.getAltura();
        int perimetro=base*3;
        int area=((base*altura)/2);
        
        jdbcTemplate.update("INSERT INTO triangulo (base,altura,perimetro,area) VALUES(?,?,?,?)", base,altura,perimetro,area);
        
        return "redirect:/resultado";
    }
    
    @GetMapping("/resultado")
    public String resultado(Model model)
    {
        List<Triangulo> triangulo=jdbcTemplate.query("SELECT * FROM triangulo", new RowMapper<Triangulo>()
        {
            @Override
            public Triangulo mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
                return new Triangulo(rs.getInt("base"), rs.getInt("altura"), rs.getInt("perimetro"), rs.getInt("area"));
            }
        });
        model.addAttribute("triangulo", triangulo);
        return "resultado";
    }
}
