//添加活动组件

import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';
import DateTime from './DateTime.js';
// import addAjax from '../ajax/add.js';

//引入的组件
import TextField from 'material-ui/TextField';
import {List,ListItem} from 'material-ui/List';
import DatePicker from 'material-ui/DatePicker';
import TimePicker from 'material-ui/TimePicker';
import Paper from 'material-ui/Paper';
import SelectField from 'material-ui/SelectField';
import MenuItem from 'material-ui/MenuItem';
import {Card, CardHeader, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

// svg图标
import NotificationEventNote from 'material-ui/svg-icons/notification/event-note';
import DeviceAccessTime from 'material-ui/svg-icons/device/access-time';
import Place from 'material-ui/svg-icons/maps/place';
import ActionAssignment from 'material-ui/svg-icons/action/assignment';
import AccessAlarm from 'material-ui/svg-icons/device/access-alarm';
import Notifications from 'material-ui/svg-icons/social/notifications';

injectTapEventPlugin();

const iconStyle={
    top:'40%',
    textColor:'#00BFA5'
};
const listStyle={
    marginBottom:'-20px',
    height:100,
};

const paperStyle={
    marginLeft:20,
};

const styles={
    marginBottom:40,
};

class AddActive extends React.Component{
    constructor(props) {
        super(props);
        this.handleSelectChange = this.handleSelectChange.bind(this);
        this.handleClick=this.handleClick.bind(this);
        this.state = {
            value: 10,
        };
    }

    handleSelectChange(event,index,value){
        this.setState({value});
    }

    handleClick(event){
        var activeInfo={
            activeTheme:this.refs.activeTheme.getValue(),//活动主题            
            startTime:this.refs.startTime.getValue(),//开始时间
            place:this.refs.place.getValue(),//地点
            activeDetail:this.refs.activeDetail.getValue(),//活动详情
            alarm:this.state.value,//提醒
            endTime:this.refs.endTime.getValue(),//结束时间
        }
        console.log(activeInfo);
    }
    render(){
        return (
            <div>
                <Paper  zDepth={0} style={styles}>
                    <ListItem
                        style={listStyle} 
                        leftIcon={<NotificationEventNote style={iconStyle}/>}
                        primaryText={<TextField hintText="请输入活动主题" floatingLabelText="活动主题" ref="activeTheme"/>}
                    />
                       
                    <ListItem 
                        style={listStyle} 
                        leftIcon={<DeviceAccessTime style={iconStyle}/>}
                        primaryText={<DateTime ref="startTime" floatingText="活动开始时间"/>}
                    />

                    <ListItem 
                        style={listStyle} 
                        leftIcon={<Place style={iconStyle}/>}
                        primaryText={<TextField hintText="请输入活动地点" floatingLabelText="活动地点" ref="place"/>}
                    />
                    <ListItem 
                        style={listStyle}
                        leftIcon={<ActionAssignment style={iconStyle} />}
                        primaryText={<TextField hintText="请输入活动详情" ref="activeDetail" floatingLabelText="活动详情" multiLine={true} rowsMax={3}/>}
                    />
                </Paper>
                <Card style={styles}>
                    <CardHeader 
                        title="更多选项"
                        actAsExpander={true}
                        showExpandableButton={true}
                    />
                    <CardText expandable={true}> 
                        <ListItem 
                            style={listStyle}
                            leftIcon={<Notifications style={{top:'20%'}}/>}
                            primaryText={
                                <SelectField value={this.state.value} onChange={this.handleSelectChange} ref="alarm">
                                  <MenuItem value={5} primaryText="提前5分钟提醒" />
                                  <MenuItem value={10} primaryText="提前10分钟提醒" />
                                  <MenuItem value={15} primaryText="提前15分钟提醒" />
                                  <MenuItem value={30} primaryText="提前30分钟提醒" />
                                  <MenuItem value={60} primaryText="提前1小时提醒" />
                                </SelectField>
                            }
                        />
                        <ListItem 
                            style={listStyle} 
                            leftIcon={<DeviceAccessTime style={iconStyle}/>}
                            primaryText={
                                <DateTime 
                                    ref="endTime" 
                                    floatingText="活动结束时间"
                                />
                            }
                        />
                    </CardText>              
                </Card>
                <RaisedButton 
                    label="确定添加" 
                    primary={true} 
                    // linkButton={true}
                    // href="/detail.html?activeId=123"
                    style={{width:'100%',height:50,fontSize:'20px'}}
                    onClick={this.handleClick}
                />
            </div>
        );
       
    };
}


ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <AddActive />
   </MuiThemeProvider>,
   document.getElementsByClassName('add')[0] 
);
