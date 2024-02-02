package com.WorkersDataBase.view.components.topbar.components.buttons;


import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.service.contract.ContractService;
import com.WorkersDataBase.service.position.PositionService;
import com.WorkersDataBase.service.worker.WorkerService;
import com.WorkersDataBase.view.components.grid.WorkersGrid;
import com.WorkersDataBase.view.interfaces.ButtonCreator;
import com.WorkersDataBase.view.interfaces.ComponentCreator;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class InjectTestDataButton
        extends Button
        implements ComponentCreator, ButtonCreator
{
    private final WorkerService workerService;
    private final WorkersGrid workersGrid;
    private final ContractService contractService;
    private final PositionService positionService;
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService()
    );
    @Override
    public void clickEvent() {
        save100RandomWorkers();
        writeRandomContractWithAllWorkers();
        workersGrid.refresh();

    }
    @Override
    public void configureComponents() {

    }
    @Override
    public void configureFront() {
        setText("Wstrzyknij dane testowe");
        addThemeVariants(
                ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_ERROR
        );
        addClickListener(buttonClickEvent -> clickEvent());
    }
    private void save100RandomWorkers(){
        generatedPeselList.forEach(pesel -> {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = fakeValuesService.bothify(lastName + "##@gmail.com");

            Worker worker = new Worker();
            worker.setFirstName(firstName);
            worker.setLastName(lastName);

            Contact contact = new Contact(email);
            contact.setWorker(worker);

            worker.setContact(contact);
            worker.setPesel(pesel);
            workerService.addWorker(worker, false);
        });
    }
    private void writeRandomContractWithAllWorkers(){
        List<Worker> workerList  = workerService.getWorkers();
        List<Position> positions = positionService.getPositions();

        workerList.forEach(worker ->
                contractService.writeContractWithWorker(
                worker,
                positions.get(ThreadLocalRandom.current().nextInt(4)).getPositionName(),
                getRandomSalary(),
                LocalDate.now(),
                generateEndDate()
                ));
    }
    private double getRandomSalary() {
        double randomDouble = ThreadLocalRandom.current().nextDouble(4242, 9000 + 0.01);
        randomDouble = Math.round(randomDouble * 100.0) / 100.0;
        return randomDouble;
    }
    private LocalDate generateEndDate() {
        int randomMonths = ThreadLocalRandom.current().nextInt(3, 61);
        return LocalDate.now().plusMonths(randomMonths);
    }
    List<String> generatedPeselList = List.of(
            "78010398723",
            "77082383532",
            "94031793352",
            "85080392357",
            "90081424457",
            "94062531329",
            "92071343496",
            "63121075661",
            "83080163597",
            "64122263734",
            "71082429672",
            "91010226838",
            "80040984946",
            "81012083449",
            "01221912392",
            "88061571284",
            "96100645197",
            "82091987466",
            "65091373163",
            "76073158481",
            "73102544778",
            "84122983928",
            "75031352251",
            "89033069521",
            "62012058567",
            "81091052554",
            "64110688161",
            "65051745429",
            "81091269428",
            "96072892614",
            "86110346588",
            "02262827348",
            "02210588633",
            "92050169752",
            "85071547724",
            "98111134185",
            "77081818525",
            "91043026414",
            "85021861799",
            "89092765721",
            "83072682785",
            "97020992868",
            "98110584639",
            "63050378451",
            "67061725695",
            "62080524681",
            "97062569976",
            "78032929626",
            "83030726427",
            "72070243256",
            "79092772425",
            "74061972637",
            "63050186526",
            "69052876362",
            "75030512766",
            "85100819732",
            "96122622723",
            "65031028777",
            "02240676935",
            "94100527789",
            "80030943324",
            "81081584955",
            "01241059857",
            "68122611467",
            "61121821466",
            "90070958325",
            "71122451311",
            "92060365319",
            "67020169436",
            "70062747333",
            "64042285335",
            "81060112359",
            "72071551875",
            "64102643888",
            "99072478716",
            "86030999976",
            "79092933336",
            "93080137492",
            "76042975938",
            "68060147156",
            "85080828289",
            "98053187267",
            "95041915598",
            "70110666362",
            "76042525829",
            "82012598739",
            "79071929581",
            "85021412162",
            "71122875869",
            "74102259376",
            "92111714981",
            "75082143143",
            "02282812731",
            "92021588621",
            "61091657584",
            "83061235648",
            "72021662642",
            "96122833356",
            "67051397118",
            "65092314837"
    );
}
