package br.com.liandro.sempreit.rest.testes.suite;

import br.com.liandro.sempreit.core.BaseTest;
import br.com.liandro.sempreit.rest.testes.*;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        Weather.class,
})
public class SuiteTestes extends BaseTest {

}
