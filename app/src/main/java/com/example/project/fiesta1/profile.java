package com.example.project.fiesta1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class profile extends AppCompatActivity {

    Button uploadbtn, choosebtn;
    String sid,scategory;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;

    DatabaseReference ref,ref1;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //image choose
        choosebtn = (Button) findViewById(R.id.s_btnChoose);

        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseimage();
            }
        });
        //upload code
        uploadbtn = (Button) findViewById(R.id.s_btn);
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadImage();

            }
        });
    }

    public void chooseimage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();

        }
    }

    private void uploadImage() {

        FirebaseStorage storage;
        StorageReference storageReference;
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        // ref = database.getReference("service_provider");
        if(filePath != null)
        {


            final FirebaseDatabase database = FirebaseDatabase.getInstance();

            EditText s_name = (EditText) findViewById(R.id.s_name);
            String sname = s_name.getText().toString();

            EditText s_add = (EditText) findViewById(R.id.s_add);
            String sadd = s_add.getText().toString();

            CheckBox deco = (CheckBox) findViewById(R.id.deco);
            if(deco.isChecked())
            {scategory= scategory+","+deco.getText().toString();
                ref = database.getReference("decoration");
                Map decoration = new HashMap();
                decoration.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(decoration);
            }

            CheckBox make = (CheckBox) findViewById(R.id.make);
            if(make.isChecked())
            {scategory= scategory+","+make.getText().toString();
                ref = database.getReference("hair_makeup");
                Map hair_makeup = new HashMap();
                hair_makeup.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(hair_makeup);
            }

            CheckBox out = (CheckBox) findViewById(R.id.out);
            if(out.isChecked())
            {scategory= scategory+","+out.getText().toString();
                ref = database.getReference("outfit");
                Map outfit = new HashMap();
                outfit.put("name",sname);
                //uid = ref.push().getKey();
                ref.child(uid).setValue(outfit);
            }

            CheckBox enter = (CheckBox) findViewById(R.id.enter);
            if(enter.isChecked())
            {scategory= scategory+","+enter.getText().toString();
                ref = database.getReference("entertainment");
                Map entertainment = new HashMap();
                entertainment.put("name",sname);
                //uid = ref.push().getKey();
                ref.child(uid).setValue(entertainment);
            }

            CheckBox cat = (CheckBox) findViewById(R.id.cat);
            if(cat.isChecked())
            {scategory= scategory+","+cat.getText().toString();
                ref = database.getReference("catering");
                Map catering = new HashMap();
                catering.put("name",sname);
                //uid = ref.push().getKey();
                ref.child(uid).setValue(catering);
            }

            CheckBox trans = (CheckBox) findViewById(R.id.trans);
            if(trans.isChecked())
            {scategory= scategory+","+trans.getText().toString();
                ref = database.getReference("transportation");
                Map transportation = new HashMap();
                transportation.put("name",sname);
                //uid = ref.push().getKey();
                ref.child(uid).setValue(transportation);
            }

            CheckBox invi = (CheckBox) findViewById(R.id.invi);
            if(invi.isChecked())
            {scategory= scategory+","+invi.getText().toString();
                ref = database.getReference("invitation");
                Map invitation = new HashMap();
                invitation.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(invitation);
            }

            CheckBox med = (CheckBox) findViewById(R.id.med);
            if(med.isChecked())
            {scategory= scategory+","+med.getText().toString();
                ref = database.getReference("media");
                Map media = new HashMap();
                media.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(media);
            }

            CheckBox cake = (CheckBox) findViewById(R.id.cake);
            if(cake.isChecked())
            {scategory= scategory+","+cake.getText().toString();
                ref = database.getReference("cakes_desserts");
                Map cakes_desserts = new HashMap();
                cakes_desserts.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(cakes_desserts);
            }

            CheckBox mis = (CheckBox) findViewById(R.id.mis);
            if(mis.isChecked())
            {scategory= scategory+","+mis.getText().toString();
                ref = database.getReference("miscellaneous");
                Map miscellaneous = new HashMap();
                miscellaneous.put("name",sname);
                // uid = ref.push().getKey();
                ref.child(uid).setValue(miscellaneous);
            }

            EditText s_minbudget = (EditText) findViewById(R.id.s_minbudget);
            String sminbudget = s_minbudget.getText().toString();

            EditText s_maxbudget = (EditText) findViewById(R.id.s_maxbudget);
            String smaxbudget = s_maxbudget.getText().toString();

            EditText s_district = (EditText) findViewById(R.id.s_district);
            String sdistrict = s_district.getText().toString();

            EditText s_lic = (EditText) findViewById(R.id.s_lic );
            String slic  = s_lic .getText().toString();

            EditText s_location = (EditText) findViewById(R.id.s_location);
            String slocation = s_location.getText().toString();

            EditText s_email = (EditText) findViewById(R.id.s_email);
            String semail = s_email.getText().toString();

            EditText s_phone = (EditText) findViewById(R.id.s_phone);
            String sphone = s_phone.getText().toString();

            if(TextUtils.isEmpty(sname)) {
                Toast.makeText(this, "plz enter the name ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(sadd)) {
                Toast.makeText(this, "plz enter the address ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(slic)) {
                Toast.makeText(this, "plz enter the license number  ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(sdistrict)) {
                Toast.makeText(this, "plz enter the district ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(scategory)) {
                Toast.makeText(this, "plz select any of the services ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(sminbudget)) {
                Toast.makeText(this, "plz enter minimum budget ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(smaxbudget)) {
                Toast.makeText(this, "plz enter maximum budget ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(semail)) {
                Toast.makeText(this, "plz enter the email id  ", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(sphone)) {
                Toast.makeText(this, "plz enter the contact number ", Toast.LENGTH_SHORT).show();
                return;
            }


            ref = database.getReference("service_provider");

            final Map service_provider = new HashMap();
            service_provider.put("name", sname);
            service_provider.put("licence_no", slic);
            service_provider.put("address", sadd);
            service_provider.put("district", sdistrict);
            service_provider.put("category", scategory);
            service_provider.put("min_budget", sminbudget);
            service_provider.put("max_budget", smaxbudget);
            service_provider.put("location", slocation);
            service_provider.put("email_id", semail);
            service_provider.put("phone", sphone);

            //uid = ref.push().getKey();
            ref.child(uid).setValue(service_provider);
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final StorageReference ref1 = storageReference.child("images/"+ uid.toString());
            ref1.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(profile.this, "Upload Successful ", Toast.LENGTH_SHORT).show();
                            Uri imageurl = taskSnapshot.getDownloadUrl();
                            String url = imageurl.toString();
                            service_provider.put("image",url);
                            ref.child(uid).setValue(service_provider);
                            Intent intent=new Intent(profile.this,server.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(profile.this, "Upload Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}
