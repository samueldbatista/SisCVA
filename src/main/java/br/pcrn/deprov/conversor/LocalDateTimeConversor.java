package br.pcrn.deprov.conversor;

import br.com.caelum.vraptor.Convert;
import br.pcrn.deprov.util.LocalDateTimeConverter;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Convert(LocalDateTime.class)
@RequestScoped
@Specializes
public class LocalDateTimeConversor extends LocalDateTimeConverter{

    /** @deprecated */
    protected  LocalDateTimeConversor(){
        this(null);
    }

    @Inject
    public LocalDateTimeConversor(Locale locale) {
        super(locale);
    }

    @Override
    public LocalDateTime convert(String value, Class<? extends LocalDateTime> type) {
        return super.convert(value, type);
    }

    @Override
    protected DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ISO_DATE_TIME;
    }
}
