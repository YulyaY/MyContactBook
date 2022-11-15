package com.example.mycontactbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontactbook.databinding.ContactListItemBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private MainActivity mainActivity;

    public ContactAdapter(ArrayList<Contact> contactArrayList,
                          MainActivity mainActivity) {
        this.contactArrayList = contactArrayList;
        this.mainActivity = mainActivity;
    }

    public void setContactArrayList(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.contact_list_item, parent, false);
//
//        return new ContactViewHolder(itemView);

        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false
        );

        return  new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact = contactArrayList.get(position);

//        holder.firstNameTextView.setText(contact.getFirstName());
//        holder.lastNameTextView.setText(contact.getLastName());
//        holder.emailTextView.setText(contact.getEmail());
//        holder.phoneNumberTextView.setText(contact.getPhoneNumber());

        holder.contactListItemBinding.setContact(contact);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.addAndEditContact(true, contact, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder{

//        private final TextView firstNameTextView;
//        private final TextView lastNameTextView;
//        private final TextView emailTextView;
//        private final TextView phoneNumberTextView;

        private ContactListItemBinding contactListItemBinding;


        public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());

            this.contactListItemBinding = contactListItemBinding;

//            firstNameTextView = itemView.findViewById(R.id.firstNameTextView);
//            lastNameTextView = itemView.findViewById(R.id.lastNameTextView);
//            emailTextView = itemView.findViewById(R.id.emailTextView);
//            phoneNumberTextView = itemView.findViewById(R.id.phoneNumberNameTextView);
        }
    }

}
