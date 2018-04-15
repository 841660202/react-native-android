/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
} from 'react-native';
import ToastExample from './ToastExample';
// import commModule from './communication';
const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
  android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  call_button(){  
  
    ToastExample.show('调用原生方法的Demo', ToastExample.SHORT);   
  } 
   /**
    * 调用原生代码
    */
  skipNativeCall() {
    let phone = '18637070949';
    // commModule.rnCallNative(phone);
  } 
  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity style={styles.welcome} onPress={this.call_button}>
          <Text style={styles.instructions}>
          Click to show native Toast
          </Text>
        </TouchableOpacity>
        <Text style={styles.welcome} onPress={this.skipNativeCall.bind(this)}>
            跳转到拨号界面
         </Text>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit App.js
        </Text>
        <Text style={styles.instructions}>
          {instructions}
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
