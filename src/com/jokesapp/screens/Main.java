package com.jokesapp.screens;

import com.jokesapp.api.APIInterface;
import com.jokesapp.api.APIClient;
import com.jokesapp.pojo.CategoryJoke;
import com.jokesapp.pojo.RandomJoke;
import java.awt.Image;
import java.util.Arrays;
import javax.swing.ImageIcon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 *
 * @author AR
 */
public class Main extends javax.swing.JFrame {
    
    private final ImageIcon image;
    private final Image scaledImage;
    private final APIInterface apiInterface;

    public Main() {
        initComponents();
        
        apiInterface = APIClient.getClient().create(APIInterface.class);
  
        image = new ImageIcon(getClass().getResource("/com/retrofit/assets/chucknorris_logo.png"));
        scaledImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(scaledImage));
        
        btnGetJoke.setEnabled(false);
        btnGetRandomJoke.setEnabled(false);
        populateCategories();
    }
    
    private void populateCategories() {
        Call<String[]> categories = apiInterface.getCategories();
        categories.enqueue(new Callback<String[]>() {
            @Override
            public void onResponse(Call<String[]> call, Response<String[]> rspns) {
                if(rspns.isSuccessful()) {
                    cmbCategories.removeAllItems();
                    btnGetJoke.setEnabled(true);
                    btnGetRandomJoke.setEnabled(true);
                    Arrays.stream(rspns.body()).forEach(category -> cmbCategories.addItem(category));
                }
                else {
                    throw new HttpException(rspns);
                }
            }

            @Override
            public void onFailure(Call<String[]> call, Throwable thrwbl) {
                System.out.println(thrwbl.getMessage());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        cmbCategories = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtJokeText = new javax.swing.JTextArea();
        btnGetJoke = new javax.swing.JButton();
        btnGetRandomJoke = new javax.swing.JButton();
        btnDebugPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jokes App");
        setResizable(false);

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        cmbCategories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading..." }));

        jLabel1.setText("Category");

        txtJokeText.setEditable(false);
        txtJokeText.setColumns(20);
        txtJokeText.setLineWrap(true);
        txtJokeText.setRows(5);
        jScrollPane1.setViewportView(txtJokeText);

        btnGetJoke.setText("Get Joke");
        btnGetJoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetJokeActionPerformed(evt);
            }
        });

        btnGetRandomJoke.setText("Get Random Joke");
        btnGetRandomJoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRandomJokeActionPerformed(evt);
            }
        });

        btnDebugPanel.setText("Debug Panel");
        btnDebugPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebugPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetJoke, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetRandomJoke)
                                .addGap(18, 18, 18)
                                .addComponent(btnDebugPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetJoke)
                    .addComponent(btnGetRandomJoke)
                    .addComponent(btnDebugPanel))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetRandomJokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRandomJokeActionPerformed
        Call<RandomJoke> randomJoke = apiInterface.getRandomJoke();
        randomJoke.enqueue(new Callback<RandomJoke>() {
            @Override
            public void onResponse(Call<RandomJoke> call, Response<RandomJoke> rspns) {
                System.out.println(rspns);
                if(rspns.isSuccessful()) {
                    txtJokeText.setText(rspns.body().value);
                }
                else {
                    throw new HttpException(rspns);
                }
            }

            @Override
            public void onFailure(Call<RandomJoke> call, Throwable thrwbl) {
                System.out.println(thrwbl.getMessage());
            }
        });
    }//GEN-LAST:event_btnGetRandomJokeActionPerformed

    private void btnGetJokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetJokeActionPerformed
        Call<CategoryJoke> categoryJoke = apiInterface.getRandomJokeOfCategory(cmbCategories.getSelectedItem().toString());
        categoryJoke.enqueue(new Callback<CategoryJoke>() {
            @Override
            public void onResponse(Call<CategoryJoke> call, Response<CategoryJoke> rspns) {
                System.out.println(rspns);
                if(rspns.isSuccessful()) {
                    txtJokeText.setText(rspns.body().value);
                }
                else {
                    throw new HttpException(rspns);
                }
            }

            @Override
            public void onFailure(Call<CategoryJoke> call, Throwable thrwbl) {
                System.out.println(thrwbl.getMessage());
            }
        });
    }//GEN-LAST:event_btnGetJokeActionPerformed

    private void btnDebugPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebugPanelActionPerformed
        new Debug().setVisible(true);
    }//GEN-LAST:event_btnDebugPanelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDebugPanel;
    private javax.swing.JButton btnGetJoke;
    private javax.swing.JButton btnGetRandomJoke;
    private javax.swing.JComboBox<String> cmbCategories;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea txtJokeText;
    // End of variables declaration//GEN-END:variables
}
