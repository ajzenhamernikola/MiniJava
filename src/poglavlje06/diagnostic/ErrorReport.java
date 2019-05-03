package poglavlje06.diagnostic;

import java.util.ArrayList;
import java.util.List;

public class ErrorReport {
    private String phase;
    private boolean wasError;
    private List<String> errorList;

    public ErrorReport(String phase) {
        this.phase = phase;
        this.wasError = false;
        this.errorList = new ArrayList<>();
    }

    public void addError(String s) {
        this.wasError = true;
        this.errorList.add(s);
    }

    public void printErrorReport() {
        if (!wasError) {
            System.out.println("No errors were found in phase: " + phase);
            return;
        }

        for (String s : this.errorList) {
            System.out.println(s);
            System.out.println();
        }

        System.exit(-1);
    }
}
