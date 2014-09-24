package com.james.codelib.guava.optional;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by james on 9/22/14.
 */
public class OptionalMain {
    public static final Logger LOG = LoggerFactory.getLogger(OptionalMain.class);

    public static void main(String[] args) {

        Student nullStu = new Student(1, "a");
        nullStu.setId(null);
        nullStu.setName(null);
        //构建一个非空对象
        Optional<Student> student = Optional.of(new Student(1, "a"));
        Optional<Student> nStudent = Optional.of(nullStu);

        //构建一个空对象
        Optional<Student> nullStudent = Optional.absent();

        List<Student> students = Lists.newArrayList();
        students.add(new Student('1', "a"));
        students.add(new Student('2', "3"));
        students.add(nullStu);

        Clazz clazz = new Clazz();
        clazz.setName("css");
        clazz.setStudents(students);
        Optional<Clazz> clazzOp = Optional.of(clazz);

        /*
         * guava 函数式调用
         * 参考：http://dreamhead.blogbus.com/logs/235334714.html
         */
//        DecorateOptional.from(clazzOp).bind(getId());
        Person person = new Person(new Place(new City(new Province("country"))));
        Optional<Person> personOptional = Optional.of(person);
        Optional<Person> nullPerson = Optional.of(new Person(new Place(new City(null))));

        Optional<String> opt = getCountryInPerson(personOptional);
        LOG.info(opt.or("nullValue"));
        Optional<String> opt1 = getCountryInPerson(nullPerson);
        LOG.info(opt1.or("nullValue"));

        DecorateOptional optional = DecorateOptional.from(personOptional)
                .bind(getPlace())
                .bind(getCity())
                .bind(getProvince())
                .bind(getCountry());
        LOG.info(optional.or("nullValue").toString());

        optional = DecorateOptional.from(nullPerson)
                .bind(getPlace())
                .bind(getCity())
                .bind(getProvince())
                .bind(getCountry());
        LOG.info(optional.or("nullValue").toString());
    }

    private static Function<Province, Optional<String>> getCountry() {
        return new Function<Province, Optional<String>>() {
            @Override
            public Optional<String> apply(Province input) {
                return Optional.fromNullable(input.getCountry());
            }
        };
    }

    private static Function<City, Optional<Province>> getProvince() {
        return new Function<City, Optional<Province>>() {
            @Override
            public Optional<Province> apply(City input) {
                return Optional.fromNullable(input.getProvince());
            }
        };
    }

    private static Function<Place, Optional<City>> getCity() {
        return new Function<Place, Optional<City>>() {
            @Override
            public Optional<City> apply(Place input) {
                return Optional.fromNullable(input.getCity());
            }
        };
    }

    private static Function<Person, Optional<Place>> getPlace() {
        return new Function<Person, Optional<Place>>() {
            @Override
            public Optional<Place> apply(Person input) {
                return Optional.fromNullable(input.getPlaceOfBirth());
            }
        };
    }

    private static Optional<String> getCountryInPerson(Optional<Person> personOptional) {
        return Optionals.bind(
                Optionals.bind(
                        Optionals.bind(
                                Optionals.bind(personOptional, getPlace()),
                                getCity()),
                        getProvince()),
                getCountry());
    }
}
