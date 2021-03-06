package com.delevry.resto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;


public class Upload_Recipe extends AppCompatActivity {

    ImageView recipeImage;
    EditText  recipeTitle,recipeDescription,recipePice;
    Uri uri;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__recipe);
        recipeImage=findViewById(R.id.iv_foodImage);
        recipeTitle=findViewById(R.id.txt_recipe_name);
        recipeDescription=findViewById(R.id.txt_recipe_description);
        recipePice=findViewById(R.id.txt_recie_price);
    }

    public void btnSelectImage(View view) {

        Intent photoPicker=new Intent(Intent.ACTION_PICK);
        photoPicker.setType("image/*");
        startActivityForResult(photoPicker,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            uri= data.getData();
            recipeImage.setImageURI(uri);


        }
        else Toast.makeText(this,"You haven't picked image",Toast.LENGTH_SHORT).show();

    }



    public  void  uploadImage(){

        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference().child("RecipeImage").child(uri.getLastPathSegment());

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while (! uriTask.isComplete());
                Uri urlImage=uriTask.getResult();
                imageUrl=urlImage.toString();
                uploadRecipe();

                Toast.makeText(Upload_Recipe.this, "image Uploaded", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void btnUploadRecipe(View view) {
        uploadImage();

    }

    private void uploadRecipe() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Recipe Uplading....");
        progressDialog.show();



        MenuData menuData= new MenuData(
                recipeTitle.getText().toString(),
                recipeDescription.getText().toString(),
                recipePice.getText().toString(),
                imageUrl
        );
        String myCurrentDataTime= DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Recipe")
                .child(myCurrentDataTime).setValue(menuData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(Upload_Recipe.this, "Recipe Uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Upload_Recipe.this,"Failed", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
