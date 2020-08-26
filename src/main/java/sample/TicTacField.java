package sample;

public class TicTacField {

    private TicTacKind fieldKind;

    public TicTacField() {
        this.fieldKind = TicTacKind.EMPTY;
    }

    public TicTacKind getFieldKind() {
        return fieldKind;
    }

    public boolean setFieldKind(TicTacKind fieldKind) {
        if (this.fieldKind==TicTacKind.EMPTY) {
            this.fieldKind = fieldKind;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacField that = (TicTacField) o;
        return (this.fieldKind.name().equals(that.getFieldKind().name()) && this.getFieldKind()!=TicTacKind.EMPTY && that.getFieldKind()!=TicTacKind.EMPTY) ;
    }


}
