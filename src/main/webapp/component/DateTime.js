// 时间日期选择器组件
/*
@param floatingText 浮动文本内容
*/
import React from 'react';
import ReactDOM from 'react-dom';

import DatePicker from 'material-ui/DatePicker';
import TimePicker from 'material-ui/TimePicker';
import TextField from 'material-ui/TextField';

class DateTime extends React.Component{
    constructor(props){
        super(props);
        this.handleDateDismiss=this.handleDateDismiss.bind(this);
        this.handleTextFocus=this.handleTextFocus.bind(this);
        this.handleDateChange=this.handleDateChange.bind(this);
        this.handleTimeChange=this.handleTimeChange.bind(this);
        this.getDateTime=this.getDateTime.bind(this);
        var now=new Date();
        this.state={
            date:this.formate(now,'date'),
            time:this.formate(now,'time')
        }
    }
    //数字填充，使之保持2位
    number2(num){
        if (num<10) {
            return '0'+num;
        }else{
            return num;
        }
    }
    formate(data,type){
        if (type==='date') {
            return data.getFullYear()+"-"+this.number2((data.getMonth()+1))+"-"+this.number2(data.getDate());
        }else if (type==='time') {
            return this.number2(data.getHours())+":"+this.number2(data.getMinutes());
        }
    }
    handleTextFocus(event){
        this.refs.myDate.focus();
    }
    getDateTime(){
        return this.state.date+" "+this.state.time;
    }
    handleDateChange(event,date){
        this.setState({
            date:this.formate(date,'date')
        });
    }
    handleTimeChange(event,time){
        this.setState({
            time:this.formate(time,'time')
        });
    }
    handleDateDismiss(event){
        this.refs.myTime.focus();
    }
    render(){
        return (
            <div>
                <TextField 
                    onFocus={this.handleTextFocus} 
                    value={this.getDateTime()}
                    id="dateTime"
                    floatingLabelText={this.props.floatingText}
                />
                <DatePicker hintText="开始日期" 
                    ref="myDate"
                    onDismiss={this.handleDateDismiss} 
                    autoOk={true}
                    onChange={this.handleDateChange}
                    style={{display:'none'}}
                />
                <TimePicker hintText="开始时间" format="24hr"
                    ref="myTime"
                    onChange={this.handleTimeChange}
                    style={{display:'none'}}
                />
            </div>
        );
    }
};

export default DateTime;
