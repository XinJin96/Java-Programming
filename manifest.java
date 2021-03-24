package self_learning1;
import java.sql.Date;

import javax.swing.*;
class Show {
    JFrame box = new JFrame();
    void manifest() { 
        Date date =new Date(0);
        JOptionPane.showMessageDialog(box, "The time now:"+date.toString());
    }
}