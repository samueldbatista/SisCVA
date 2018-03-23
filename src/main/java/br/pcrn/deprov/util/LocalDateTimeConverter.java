package br.pcrn.deprov.util;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;
import com.google.common.base.Strings;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Convert(LocalDateTime.class)
@RequestScoped
public class LocalDateTimeConverter implements Converter<LocalDateTime> {
    private final Locale locale;

    /** @deprecated */
    protected LocalDateTimeConverter() {
        this((Locale)null);
    }

    @Inject
    public LocalDateTimeConverter(Locale locale) {
        this.locale = locale;
    }

    public LocalDateTime convert(String value, Class<? extends LocalDateTime> type) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        } else {
            try {
                return LocalDateTime.parse(value, this.getFormatter());
            } catch (DateTimeParseException var4) {
                throw new ConversionException(new ConversionMessage("is_not_a_valid_datetime", new Object[]{value}));
            }
        }
    }

    protected DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(this.locale);
    }
}