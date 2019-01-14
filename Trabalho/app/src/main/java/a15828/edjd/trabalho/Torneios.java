package a15828.edjd.trabalho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Torneios extends RealmObject {

    String  id;
    String nome;
    int Nequipas;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNequipas() {
        return Nequipas;
    }

    public void setNequipas(int nequipas) {
        Nequipas = nequipas;
    }

    public Torneios(String nome,int nequipas){
        this.nome = nome;
        this.Nequipas=nequipas;


    }
    public Torneios() {
        this.id          = UUID.randomUUID().toString();
        this.nome      = "";
        this.Nequipas   = 0;


    }
    public static void add(final Torneios t, Realm realm){
        RealmResults<Torneios> torneios = realm.where(Torneios.class)
                .equalTo("id", t.id)
                .findAll();
        if (torneios.size()==0){
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm) {
                    Torneios item = realm.createObject(Torneios.class);
                    item.id = t.id;
                    item.nome     =   t.nome;
                    item.Nequipas  =   t.Nequipas ;

                }
            });
        }
    }

    public static void update(final Torneios tt, Realm realm){
        final RealmResults<Torneios> torneio = realm.where(Torneios.class)
                .equalTo("id", tt.id)
                .findAll();
        if (torneio.size()>0){
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm) {
                    torneio.first().nome    =   tt.nome    ;
                    torneio.first().Nequipas  =   tt.Nequipas ;


                }
            });
        }
    }

    public static void delete(final Torneios tt, Realm realm){
        final RealmResults<Torneios> torneio = realm.where(Torneios.class)
                .equalTo("id", tt.id)
                .findAll();
        if (torneio.size()>0){
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm) {
                    torneio.first().deleteFromRealm();
                }
            });
        }
    }
}

