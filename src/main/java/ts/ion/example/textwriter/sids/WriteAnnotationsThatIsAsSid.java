package ts.ion.example.textwriter.sids;

import com.amazon.ion.IonWriter;
import com.amazon.ion.SymbolToken;
import com.amazon.ion.system.IonTextWriterBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class WriteAnnotationsThatIsAsSid {

    IonWriter itw;
    StringBuilder data;
    ByteArrayOutputStream out;
    String annotation;
    SymbolToken st;


    public WriteAnnotationsThatIsAsSid() {
        IonTextWriterBuilder itwBuilder = IonTextWriterBuilder.standard();
        this.data = new StringBuilder("");
        this.annotation = "";
        out = new ByteArrayOutputStream();
        this.itw = itwBuilder.build(out);
    }

    public WriteAnnotationsThatIsAsSid(String data) {
        this();
        this.data = new StringBuilder(data);
    }

    public void setText(String s) {
        this.data = new StringBuilder(s);
    }

    public void setAnnotation(String s) {
        this.annotation = s;
    }

    public String doIt() throws IOException {
        if (!this.annotation.isEmpty()) {
            itw.addTypeAnnotation(this.annotation);
        }

        itw.writeString(this.data.toString());

        itw.finish();
        return out.toString();
    }




}
