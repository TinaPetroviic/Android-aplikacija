package com.example.flowers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;


public class FlowersActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FlowersRecyclerAdapter flowersRecyclerAdapter;
    public static Plants selectedPlant;
    private ArrayList<Plants> plantsArrayList;
    MenuItem logout;
    private Object View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers3);
        this.recyclerView = findViewById(R.id.recyclerView);
        plantsList();
        setUpRecyclerView();

    }


    private void plantsList() {

        plantsArrayList = new ArrayList<>();
        plantsArrayList.add(new Plants("Ruža", R.drawable.ruza, "Ruža (latinski: Rosa) rod je drvenastih biljaka iz familije Rosaceae. Uzgaja se zbog lijepih mirisnih cvjetova i do danas postoje mnogi hibridi i kultivari ruža koji se međusobno razlikuju po boji i izgledu cvijeta, mirisu i postojanju trnova.Ružu nazivaju i kraljicom cvijeća. Ružine latice sadrže eterična ulja, tanine, šećer, limunsku, jabučnu, vinsku i ćilibarnu kiselinu te niz aromatičnih djelotvornih tvari.Ruža se pored svoje ljepote i mirisa kao ukrasno cvijeće koristi i u: kozmetici, medicini i kulinarstvu. U kozmetici kao razni mirisi ruževa za usne. U medicini kao dio u lijeku. U kulinarstvu kao proizvod pod imenom ružina vodica.", 1));
        plantsArrayList.add(new Plants("Maslačak", R.drawable.maslacak, "Maslačak (lat. Taraxacum) rod porodice glavočike (Asteraceae, raniji naziv Compositae). Obično se nalazi u krajevima s umjerenom i hladnom klimom. Pojavljuje se na livadama, parkovima, vrtovima, uz putove i živice. Uspijeva i u visokim planinama, ali ondje mu je rozeta mnogo manja. Izgled biljke se uvelike mijenja ovisno o staništu. Cvate od travnja do listopada. Nakon cvjetanja pojavljuje se sjeme, poredano kao zračna lopta, s mnogo sjemenki koje se šire pomoću vjetra. U pučkoj medicini koristi se kao gorko sredstvo, kolagog, aperitiv te za smanjivanje masnoće u krvi. Maslačak je također jestiv, mladi listovi koriste se kao salata, cvjetovi za pripremu medu sličnog sirupa,te vina i pive. ", 2));
        plantsArrayList.add(new Plants("Ivančica", R.drawable.ivancica, "Ivančica ili margareta je trajna zeljasta biljka iz porodice glavočika (Asteraceae). Stabljika je uspravna, jednostavna ili slabo razgranata i naraste do 90 cm visine. Listovi su naizmjenični, duguljasti, goli ili rijetko dlakavi i nepravilno nazubljeni. Prizemni listovi nalaze se na dugoj peteljci, listovi stabljike su na kratkoj peteljci, gornji listovi su sjedeći i cjelovitih rubova. Cvjetne glavice su pojedinačne, promjera 3-6 cm i smještene na vrhovima dugih stapki. U središtu su smješteni cjevasti, zlatnožuti cvjetovi a na rubovima su bijeli jezičasti cvjetovi dužine 1-2 cm. Često se uzgaja u vrtovima i cvjetnjacima, razmnožava se sjemenom u proljeće ili dijeljenjem u jesen i proljeće. Odgovara joj sunčano ili polusjenovito mjesto, obična vrtna i redovito vlažna ali drenirana zemlja.", 3));
        plantsArrayList.add(new Plants("Šafran", R.drawable.safran, "Proljetni šafran (Crocus vernus) je trajnica iz porodice perunika (Iridaceae). Jedan je od prvih vjesnika proljeća, cvate već u veljači provirujući kroz snijeg. Visoka je 10-15 cm. Cvijet se otvara danju za sunčanog vremena, traje 3-4 dana a nalazi na stapci bez listova, oni se kasnije razviju. Ocvijeće se sastoji od šest latica ljubičaste i bijele boje. U sredini se nalaze tri prašnika te jedan tučak. Plod je tobolac sa sjemenkama blizu tla.", 4));
        plantsArrayList.add(new Plants("Ljiljan", R.drawable.ljiljan, "Ljiljan (lat. Lilium) je rod jednosupnica iz porodice ljiljani (Liliaceae), trajnica s lukovicom i nadzemnom stabljikom. Podzemna stabljika je crepasta lukovica iz koje izlazi izbojak s pojedinačnim cvjetovima u štitastom cvatu. Naraste u visinu 50–100 cm. Boje ljiljana su: bijela, žuta, ružičasta, narandžasta i crvena. Plod je tobolac s 500 sjemenki. Cvjetovi su krupni, ljevkasti ili zvonoliki. Listići cvijeća su srasli ili djelomično slobodni, više ili manje savijeni unatrag.", 5));
        plantsArrayList.add(new Plants("Ljubičica", R.drawable.ljubicica, "Ljubičica ili ljubica je cvjetnica roda Viola iz porodice Violaceae.Najviše vrsta ljubičica su višegodišnje, a neke jednogodišnje, izuzev nekolicine čiji je habitus u vidu malih grmova. Neke vrste se uzgajaju se u hortikulturi, kao ukrasni cvjetovi na obodima vrtova ili nihovim kamenitim površinama. Posebno intezivno se uzgajaju na proljeće na ukrasnim površinama i u sezonio jesen-zima, u saksijama.Baštovanski termini za ljubičicu su viola i violetta, kao i općenito u holtikulturi za upadljive hibridne biljke malih cvjetova srednje veličine, različitih boja i njihovih kombinacija.", 6));
        plantsArrayList.add(new Plants("Hortenzija", R.drawable.hortenzija, "Hortenzija (lat. Hydrangea) je rod od oko 70-75 vrsta kritosjemenjača.Većina vrsta su grmovi, oko 1-3 m visoki, ostale su mala stabla i penjačice, koje mogu doseći do 30 m u visinu uspinjući se na stabla. Mogu biti listopadne ili vazdazelene, a većina kultiviranih vrsta su listopadne.Hortenzija cvjeta od ranog proljeća do kasne jeseni. Mnoge vrste imaju cvatove koje sadrže dva tipa cvjetova, male plodne cvjetove u sredini cvata i velike, neplodne cvjetove raspoređene u kružnicama oko centra svakog cvata. Ostale vrste imaju sve jednake i plodne cvjetove.", 7));
        plantsArrayList.add(new Plants("Maćuhica", R.drawable.macuhica, "Maćuhica (lat. Viola tricolor), poznata je i česta livadna biljka iz porodice Violaceae. Naraste do 15 cm visine, cvjetovi su promjera do 1,5 cm, purpurne, plave, bijele ili žute boje, cvatnje od travnja do rujna. Biljka je ljekovita, a postoji i velik broj kultiviranih odlika, ove se pak uzgajaju isključivo zbog cvjetova.Koristi se u tradicionalnoj narodnoj medicini kao lijek za mnoge bolesti: škrofule , kašalj, kilu, zubobolju,reumatske bolesti i mnoge druge.", 8));

    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.flowersRecyclerAdapter = new FlowersRecyclerAdapter(plantsArrayList, this, new OnCardClickListener() {
            @Override
            public void didClickOnCard(int position) {
                System.out.println("");
                Plants plants = plantsArrayList.get(position);
                FlowersActivity3.selectedPlant = plants;
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(flowersRecyclerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        ArrayList<Plants> filteredlist = new ArrayList<Plants>();

        for (Plants item : plantsArrayList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "Nije pronađeno..", Toast.LENGTH_SHORT).show();
        } else {
            flowersRecyclerAdapter.filterList(filteredlist);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logout){
            AlertDialog.Builder builder = new AlertDialog.Builder(FlowersActivity3.this);
            builder.setMessage("Sigurni ste da se želite odjaviti?");
            builder.setCancelable(true);

            builder.setNegativeButton("Da", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setPositiveButton("Ne", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return true;
    }

}
