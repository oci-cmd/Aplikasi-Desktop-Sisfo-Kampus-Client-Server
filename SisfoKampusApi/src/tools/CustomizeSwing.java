/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.awt.Component;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rosidin
 */
public class CustomizeSwing {
    public static void autoResizeColumn(JTable jTable) {
	JTableHeader header = jTable.getTableHeader();
        int rowCount = jTable.getRowCount();

        final Enumeration columns = jTable.getColumnModel().getColumns();
        while(columns.hasMoreElements()){
                TableColumn column = (TableColumn)columns.nextElement();
                int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
                int width = (int)jTable.getTableHeader().getDefaultRenderer()
                                .getTableCellRendererComponent(jTable, column.getIdentifier()
                                                , false, false, -1, col).getPreferredSize().getWidth();

                for(int row = 0; row<rowCount; row++){
                        int preferedWidth = (int)jTable.getCellRenderer(row, col).getTableCellRendererComponent(jTable,
                                        jTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                        width = Math.max(width, preferedWidth);
                }
                header.setResizingColumn(column); // this line is very important
                column.setWidth(width+jTable.getIntercellSpacing().width);
        }
    }

    public static void autoResizeColWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int margin = 5;

        for (int i = 0; i < table.getColumnCount(); i++) {
            int                     vColIndex = i;
            DefaultTableColumnModel colModel  = (DefaultTableColumnModel) table.getColumnModel();
            TableColumn             col       = colModel.getColumn(vColIndex);
            int                     width     = 0;

            // Get width of column header
            TableCellRenderer renderer = col.getHeaderRenderer();

            if (renderer == null) {
                renderer = table.getTableHeader().getDefaultRenderer();
            }

            Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);

            width = comp.getPreferredSize().width;

            // Get maximum width of column data
            for (int r = 0; r < table.getRowCount(); r++) {
                renderer = table.getCellRenderer(r, vColIndex);
                comp     = renderer.getTableCellRendererComponent(table, table.getValueAt(r, vColIndex), false, false,
                        r, vColIndex);
                width = Math.max(width, comp.getPreferredSize().width);
            }

            // Add margin
            width += 2 * margin;

            // Set the width
            col.setPreferredWidth(width);
        }

        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(
            SwingConstants.LEFT);

        // table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);

        //return table;
    }

}
