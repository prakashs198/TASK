package com.example.table.controller;

import com.example.table.entity.Table1;
import com.example.table.entity.Table2;
import com.example.table.repository.Table1Repository;
import com.example.table.repository.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private Table1Repository table1Repository;

    @Autowired
    private Table2Repository table2Repository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Table1> table1Data = table1Repository.findAll();
        List<Table2> table2Data = table2Repository.findAll();

        model.addAttribute("table1Data", table1Data);
        model.addAttribute("table2Data", table2Data);

        return "dashboard";
    }

    @PostMapping("/merge")
    public String mergeTables() {
        List<Table1> table1Data = table1Repository.findAll();
        for (Table1 table1Record : table1Data) {
            Table2 table2Record = new Table2();
            table2Record.setId(table1Record.getId());
            table2Record.setName(table1Record.getName());
            table2Record.setValue(table1Record.getValue());
            table2Repository.save(table2Record);
        }
		return "redirect:/dashboard";
    }
//    @PostMapping("/merge")
//        public String mergeTables1() {
//            List<Table2> table2Data = table2Repository.findAll();
//            for (Table2 table2Record : table2Data) {
//                Table1 table1Record = new Table1();
//                table1Record.setId(table2Record.getId());
//                table1Record.setName(table2Record.getName());
//                table1Record.setValue(table2Record.getValue());
//                table1Repository.save(table1Record);
//            }
//        return "redirect:/dashboard";
//    }
}
