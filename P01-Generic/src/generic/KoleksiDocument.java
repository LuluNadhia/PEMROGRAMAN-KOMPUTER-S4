package generic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP VICTUS
 */
public class KoleksiDocument extends AbstractTableModel{
    List<Document> list = new ArrayList<>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    synchronized public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getFileName();
            case 1 : return list.get(rowIndex).getFileSize();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "JUDUL LAGU";
            case 1 : return "UKURAN";
            default: return "";
        }
    }
    
    public void add(Document m) {
        list.add(m);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }

    public void set(int i, Document m) {
        list.set(i, m);
        fireTableDataChanged();
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void remove(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public Document get(int row) {
        return (Document) list.get(row);
    }

    
}
