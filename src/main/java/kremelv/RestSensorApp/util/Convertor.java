package kremelv.RestSensorApp.util;

import org.modelmapper.ModelMapper;

public class Convertor {

    public static <T,D> D convert(T source, Class<D> destinationType) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source,destinationType);
    }
}
