package com.inc.runkdown.cookapp_01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by RunkDowN on 01.07.16.
 */
public class BackgroudWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroudWorker (Context ctx) {
        context = ctx;
    }
    public static String basic_url = "http://109.86.225.246/";
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = basic_url + "login_mobile.php";
        String register_url = basic_url + "signup_mobile.php";
        String addorder_url = basic_url + "add_order.php";

        if(type.equals("login")) {
            try {

                String user_name = params [1];
                String password = params [2];
                System.out.println("=======USERNAME, PASSWORD ON LOGIN BACKGROUND");
                System.out.println(user_name + password);
                System.out.println("==================================");
                System.out.println("======BackgroundWorker (basic) basic url / login url/ register url / addorder url");
                System.out.println(basic_url + "--" + login_url + "--" + register_url + "--" + addorder_url);
                System.out.println("==================================");
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"
                        + URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("register")) {
            try {
                String username = params [1];
                String email = params [2];
                String password = params [3];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+"&"
                        + URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        + URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("addOrder")) {
            try {
                String quantity = params [1];
                String id_print = params [2];
                String id_color = params [3];
                String id_pay = params [4];
                String dateNow = params [5];
                String dateFinish = params [6];
                String email = params [7];
                String image = params [8]+".png";

                System.out.println(quantity);
                System.out.println(id_print);
                System.out.println(id_color);
                System.out.println(id_pay);
                System.out.println(dateNow);
                System.out.println(dateFinish);
                System.out.println(email);
                System.out.println(image);

                URL url = new URL(addorder_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("quantity", "UTF-8")+"="+URLEncoder.encode(quantity, "UTF-8")+"&"
                        + URLEncoder.encode("id_print", "UTF-8")+"="+URLEncoder.encode(id_print, "UTF-8")+"&"
                        + URLEncoder.encode("id_color", "UTF-8")+"="+URLEncoder.encode(id_color, "UTF-8")+"&"
                        + URLEncoder.encode("id_pay", "UTF-8")+"="+URLEncoder.encode(id_pay, "UTF-8")+"&"
                        + URLEncoder.encode("dateNow", "UTF-8")+"="+URLEncoder.encode(dateNow, "UTF-8")+"&"
                        + URLEncoder.encode("dateFinish", "UTF-8")+"="+URLEncoder.encode(dateFinish, "UTF-8")+"&"
                        + URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        + URLEncoder.encode("image", "UTF-8")+"="+URLEncoder.encode(image, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        if (result.equals("Success")) {
            System.out.println("==================================");
//            Intent openThree = new Intent(context, LoginFragment.class);
//            context.startActivity(openThree);
            System.out.println("SUCCCEEEEEESSSS");
            System.out.println("BG WORKER WORK FINE");
            System.out.println("==================================");
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}


